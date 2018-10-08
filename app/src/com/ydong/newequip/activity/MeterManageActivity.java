package com.ydong.newequip.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.config.ApiService;
import com.ydong.newequip.model.InspectorCountBean;
import com.ydong.newequip.uitls.LogUtils;
import com.ydong.newequip.uitls.ToastUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Yanbin on 2018/9/20.
 * 描述:抄表管理分类
 */
public class MeterManageActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_num1)
    TextView tvNum1;
    @BindView(R.id.tv_num2)
    TextView tvNum2;
    @BindView(R.id.tv_num3)
    TextView tvNum3;
    @BindView(R.id.tv_num4)
    TextView tvNum4;

    InspectorCountBean mBean;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_meter_manage;
    }


    @Override
    public void aidHandleMessage(int what, int type, Object obj) {
        super.aidHandleMessage(what, type, obj);
        switch (what) {
            case 10004:
                switch (type) {
                    case 10031:
                        hideCustomProgressDialog();
                        LogUtils.d("巡检工单工单", obj);
                        mBean = JSONArray.parseObject(obj.toString(), InspectorCountBean.class);
                        tvNum1.setText(mBean.getData().getJieshouCount() + "");
                        tvNum2.setText(mBean.getData().getXunjianCount() + "");
                        tvNum3.setText(mBean.getData().getYixunjianCount() + "");
                        tvNum4.setText(mBean.getData().getTotalCount() + "");
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
        sendHttpGet(ApiService.QUERY_METER_COUNT, param, 10031);
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

    @OnClick({R.id.tobe_received, R.id.wait_inspector, R.id.tobe_repaired,R.id.all_inspector})
    public void onClick(View view) {
        Intent intent = new Intent(baseContext, InspectorListActivity.class);
        switch (view.getId()) {
            case R.id.tobe_received:
                if (mBean.getData().getJieshouCount() > 0) {
                    intent.putExtra("status", "1");
                    intent.putExtra("titleName", "待接收");
                    startActivity(intent);
                }else{ToastUtils.showShort("没有数据！");}
                break;
            case R.id.wait_inspector:
                if (mBean.getData().getXunjianCount() > 0) {
                    intent.putExtra("status", "2");
                    intent.putExtra("titleName", "待巡检");
                    startActivity(intent);
                }else{ToastUtils.showShort("没有数据！");}
                break;
            case R.id.tobe_repaired:
                if (mBean.getData().getYixunjianCount() > 0) {
                    intent.putExtra("status", "3");
                    intent.putExtra("titleName", "已巡检");
                    startActivity(intent);
                }else{ToastUtils.showShort("没有数据！");}
                break;
            case R.id.all_inspector:
                ToastUtils.showShort("完善中...");
                break;

        }
    }
}
