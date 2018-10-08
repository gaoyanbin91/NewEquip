package com.ydong.newequip.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.config.ApiService;
import com.ydong.newequip.model.MaintainCountBean;
import com.ydong.newequip.uitls.LogUtils;
import com.ydong.newequip.uitls.ToastUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Yanbin on 2018/9/10.
 * 描述:维修管理
 */
public class MaintainManageActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_num1)
    TextView tv_num1;
    @BindView(R.id.tv_num2)
    TextView tv_num2;
    @BindView(R.id.tv_num3)
    TextView tv_num3;
    @BindView(R.id.tv_num4)
    TextView tv_num4;
    @BindView(R.id.tv_num5)
    TextView tv_num5;
    MaintainCountBean bean;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_maintain_manage;
    }

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
                switch (type) {
                    case 10021:
                        hideCustomProgressDialog();
                        LogUtils.d("维修工单", obj);
                        bean = JSONArray.parseObject(obj.toString(), MaintainCountBean.class);
                        tv_num1.setText(bean.getData().getDaijieshouCount() + "");
                        tv_num2.setText(bean.getData().getDaidaochangCount() + "");
                        tv_num3.setText(bean.getData().getDaichuliCount() + "");
                        tv_num4.setText(bean.getData().getYichuliCount() + "");
                        tv_num5.setText(bean.getData().getTotalCount() + "");
                        break;
                }

                break;
            case 10003:
                hideCustomProgressDialog();
                ToastUtils.showShort("请检查网络");
                break;

        }
    }

    @Override
    public void initData() {
        showProgressDialog("加载中...");
        HashMap<String, String> param = new HashMap<>();
        sendHttpGet(ApiService.QUERY_MAINTAIN_COUNT, param, 10021);
    }

    @OnClick({R.id.tobe_received, R.id.tobe_repaired, R.id.wait_present,
            R.id.ready_repaired,R.id.table_all})
    public void onClick(View view) {
        Intent mIntent = new Intent(baseContext, MaintainListAty.class);
        switch (view.getId()) {
            case R.id.tobe_received://待接收
                if (bean.getData().getDaijieshouCount() > 0) {
                    mIntent.putExtra("status", "0");
                    mIntent.putExtra("titleName", "待接收");
                    startActivity(mIntent);
                }else{ToastUtils.showShort("没有数据！");}
                break;
            case R.id.wait_present://待到场
                if (bean.getData().getDaidaochangCount() > 0) {
                    mIntent.putExtra("status", "1");
                    mIntent.putExtra("titleName", "待到场");
                    startActivity(mIntent);
                }else{ToastUtils.showShort("没有数据！");}
                break;
            case R.id.tobe_repaired://待维修
                if (bean.getData().getDaichuliCount() > 0) {
                    mIntent.putExtra("status", "2");
                    mIntent.putExtra("titleName", "待维修");
                    startActivity(mIntent);
                }else{ToastUtils.showShort("没有数据！");}
                break;
            case R.id.ready_repaired://已维修
                if (bean.getData().getYichuliCount() > 0) {
                    mIntent.putExtra("status", "3");
                    mIntent.putExtra("titleName", "已维修");
                    startActivity(mIntent);
                }else{ToastUtils.showShort("没有数据！");}

                break;
            case R.id.table_all:
                ToastUtils.showShort("完善中...");
//                if (bean.getData().getYichuliCount() > 0) {
//                    mIntent.putExtra("status", "4");
//                    mIntent.putExtra("titleName", "工单管理");
//                    startActivity(mIntent);
//                }
                break;

        }
    }
}
