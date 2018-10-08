package com.ydong.newequip.activity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.uitls.QRCodeUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Yanbin on 2018/9/10.
 * 描述:设备管理详情页
 */
public class DeviceManageDetailAty extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_code)
    TextView textCode;//编号
    @BindView(R.id.text_name)
    TextView textName;//名称
    @BindView(R.id.text_major)
    TextView textMajor;//专业
    @BindView(R.id.text_type)
    TextView textType;//类别
    @BindView(R.id.text_system)
    TextView textSystem;//系统
    @BindView(R.id.text_region)
    TextView textRegion;//区域
    @BindView(R.id.text_model)
    TextView textModel;//型号
    @BindView(R.id.text_postion)
    TextView textPostion;//具体位置

    ImageView iv_qecode;
    TextView text_cancel,textView3;//取消
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_device_manage_detail;
    }

    @Override
    public void initData() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textCode.setText(TextUtils.isEmpty(getIntent().getStringExtra("code")) ? String.valueOf("") : getIntent().getStringExtra("code"));
        textName.setText(TextUtils.isEmpty(getIntent().getStringExtra("name")) ? String.valueOf("") : getIntent().getStringExtra("name"));
        textMajor.setText(TextUtils.isEmpty(getIntent().getStringExtra("major")) ? String.valueOf("") : getIntent().getStringExtra("major"));
        textType.setText(TextUtils.isEmpty(getIntent().getStringExtra("type")) ? String.valueOf("") : getIntent().getStringExtra("type"));
        textRegion.setText(TextUtils.isEmpty(getIntent().getStringExtra("region")) ? String.valueOf("") : getIntent().getStringExtra("region"));
        textPostion.setText(TextUtils.isEmpty(getIntent().getStringExtra("postion")) ? String.valueOf("") : getIntent().getStringExtra("postion"));

    }

    @OnClick({R.id.ll_qrcode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_qrcode:
                showQRCode();//显示二维码
                break;
        }
    }

    /**
     * 显示二维码
     */
    private void showQRCode() {
        final Dialog alertDialog = new Dialog(baseContext);
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(R.layout.verl_code_dialog);
        iv_qecode = window.findViewById(R.id.iv_qrcode);
        text_cancel = window.findViewById(R.id.text_cancel);
        textView3 = window.findViewById(R.id.textView3);
        textView3.setText(TextUtils.isEmpty(getIntent().getStringExtra("code")) ? String.valueOf("") : getIntent().getStringExtra("code"));
        Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap(getIntent().getStringExtra("code"), 480, 480);
        iv_qecode.setImageBitmap(mBitmap);
        text_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
