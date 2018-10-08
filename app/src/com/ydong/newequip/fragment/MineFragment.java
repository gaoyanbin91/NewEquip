package com.ydong.newequip.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ydong.newequip.R;
import com.ydong.newequip.activity.LoginActivity;
import com.ydong.newequip.activity.RevisePsdActivity;
import com.ydong.newequip.fragment.base.BaseFragment;
import com.ydong.newequip.uitls.AppConfig;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Yanbin on 2018/9/6.
 * 描述: 我的
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.text_nike_name)
    TextView textNikeName;//姓名
    @BindView(R.id.text_role)
    TextView textRole;//岗位
    @BindView(R.id.text_phone)
    TextView textPhone;//手机号


    @Override
    public int getFragmentViewLayout() {
        return R.layout.fragment_home_mine;
    }

    @Override
    public void initData() {

        textNikeName.setText(AppConfig.getInstance().getString("nikeName", "") + " . ");
        textPhone.setText(AppConfig.getInstance().getString("phone", ""));
        textRole.setText(AppConfig.getInstance().getString("roleName", ""));
    }

    @OnClick({R.id.iv_quite,R.id.ll_psd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_quite:
                showDialog();
                break;
            case R.id.ll_psd:
                startActivity(new Intent(getActivity(), RevisePsdActivity.class));
                break;

        }
    }

    /**
     * 退出登录
     */
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setTitle("提示");
        builder.setMessage("确定要退出当前登录用户吗?");
        builder.setCancelable(true);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
                AppConfig.getInstance().putString("username", "");
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });
        builder.show();
    }
}
