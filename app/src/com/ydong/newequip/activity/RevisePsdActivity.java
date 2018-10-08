package com.ydong.newequip.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.config.ApiService;
import com.ydong.newequip.model.ResultBean;
import com.ydong.newequip.uitls.AppConfig;
import com.ydong.newequip.uitls.LogUtils;
import com.ydong.newequip.uitls.ToastUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Yanbin on 2018/9/20.
 * 描述:修改密码
 */
public class RevisePsdActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.edt_old_psd)
    EditText edtOldPsd;//旧密码
    @BindView(R.id.edt_new_psd)
    EditText edtNewPsd;//新密码
    @BindView(R.id.edt_new_psd_2)
    EditText edtNewPsd2;//确定密码


    @Override
    public void initView() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }


    @Override
    public void aidHandleMessage(int what, int type, Object obj) {
        super.aidHandleMessage(what, type, obj);
        switch (what) {

            case 10004:
                hideCustomProgressDialog();

                Gson gson = new Gson();
                LogUtils.d("修改密码", obj.toString());
                ResultBean resultBean = gson.fromJson(obj.toString(), ResultBean.class);
                if (resultBean.isSuccess()) {
                    ToastUtils.showShort(resultBean.getMsg());
                    startActivity(new Intent(baseContext, LoginActivity.class));
                    exitApp();
                   // finish();
                }
                break;
            case 10003:
                hideCustomProgressDialog();

                // ToastUtils.showShort(obj.toString());
                ToastUtils.showShort(obj.toString());
                break;
        }
    }

    /**
     * 修改密码
     */
    private void revisePsd() {
        if (TextUtils.isEmpty(edtOldPsd.getText().toString())) {
            ToastUtils.showShort("请输入旧密码");
            return;
        } else if (!edtOldPsd.getText().toString().equals(AppConfig.getInstance().getString("password", ""))) {
            ToastUtils.showShort("旧密码错误");
            return;

        } else if (TextUtils.isEmpty(edtNewPsd.getText().toString()) || edtNewPsd.getText().toString().length() < 6) {
            ToastUtils.showShort("请输入不少于6位的密码");
            return;
        } else if (TextUtils.isEmpty(edtNewPsd2.getText().toString()) || edtNewPsd2.getText().toString().length() < 6) {
            ToastUtils.showShort("请输入不少于6位的密码");
            return;
        } else if (!edtNewPsd.getText().toString().equals(edtNewPsd2.getText().toString())) {
            ToastUtils.showShort("两次密码输入不一致");
            return;
        }
        showProgressDialog("正在修改...");
        HashMap<String, String> reviceMap = new HashMap<>();
        reviceMap.put("oldPassword", edtOldPsd.getText().toString());
        reviceMap.put("password", edtNewPsd.getText().toString());
        reviceMap.put("id", AppConfig.getInstance().getString("userId", ""));
        sendHttpPost(ApiService.MOD_PASSWORD, reviceMap, 11000);
    }

    @OnClick(R.id.txt_revice)
    public void onClick() {
        revisePsd();//修改密码
    }

    @Override
    public View[] filterViewByIds() {
        View[] views = {edtNewPsd, edtOldPsd, edtNewPsd2};
        return views;
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.edt_new_psd_2, R.id.edt_old_psd, R.id.edt_new_psd};
        return ids;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_revice_psd;
    }

}
