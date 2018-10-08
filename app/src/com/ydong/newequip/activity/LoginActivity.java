package com.ydong.newequip.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.config.ApiService;
import com.ydong.newequip.model.LoginBean;
import com.ydong.newequip.uitls.AppConfig;
import com.ydong.newequip.uitls.LogUtils;
import com.ydong.newequip.uitls.ToastUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Yanbin on 2018/9/7.
 * 描述:
 */
public class LoginActivity extends BaseActivity implements TextWatcher {

    private final static String TAG = LoginActivity.class.getName();

    @BindView(R.id.mobile_edittext)
    EditText mobileEditText;//登录手机号
    @BindView(R.id.pwd_edittext)
    EditText pwdEditText;//登录密码
    @BindView(R.id.clear_pwd_imageview)
    ImageView clearPwdImageView;//清除输入密码
    @BindView(R.id.phone_delte_imageview)
    ImageView phoneDeleteImageView;//清除输入密码
    @BindView(R.id.showpwd_imageview)
    ImageView showPwdImageView;//显示密码
    @BindView(R.id.login_button)
    Button loginButton;//登录按钮
    LoginBean loginBean;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_new_login;
    }

    @Override
    public void aidHandleMessage(int what, int type, Object obj) {
        super.aidHandleMessage(what, type, obj);
        switch (what) {

            case 10004:
                hideCustomProgressDialog();
                loginButton.setEnabled(true);
                Gson gson = new Gson();
                LogUtils.d("登录", obj.toString());

                loginBean = gson.fromJson(obj.toString(), LoginBean.class);
//                LogUtils.i("Success",loginBean.getDesc());
                if (loginBean.isSuccess()) {
                    AppConfig.getInstance().putString("userId", loginBean.getData().getId());
                    AppConfig.getInstance().putString("nikeName", loginBean.getData().getNickname());
                    AppConfig.getInstance().putString("phone", loginBean.getData().getPhone());
                    AppConfig.getInstance().putString("roleName", loginBean.getData().getRoleName());
                    ToastUtils.showShort(loginBean.getMsg());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    ToastUtils.showShort(loginBean.getMsg());
                }
                break;
            case 10003:
                hideCustomProgressDialog();
                loginButton.setEnabled(true);
                // ToastUtils.showShort(obj.toString());
                ToastUtils.showShort(obj.toString());
                break;
        }
    }

    @Override
    public void initView() {
        if (AppConfig.getInstance().getString("username", "") != null&&AppConfig.getInstance().getString("username", "") !="") {
            mobileEditText.setText(AppConfig.getInstance().getString("username", ""));
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        pwdEditText.addTextChangedListener(this);
        pwdEditText.setHint(getResources().getString(R.string.login_input_password));
        pwdEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        InputFilter[] filters = {new InputFilter.LengthFilter(20)};
        pwdEditText.setFilters(filters);

        showPwdImageView.setVisibility(View.VISIBLE);

        mobileEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString().trim().replace(" ", "");
                if (!TextUtils.isEmpty(str) && mobileEditText.hasFocus()) {
                    phoneDeleteImageView.setVisibility(View.VISIBLE);
                } else {
                    phoneDeleteImageView.setVisibility(View.GONE);
                }
            }
        });
        mobileEditText.addTextChangedListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.pwd_forget_textview, R.id.login_button, R.id.phone_delte_imageview, R.id.clear_pwd_imageview, R.id.showpwd_imageview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pwd_forget_textview:

                ToastUtils.showShort("忘记密码");
                break;

            case R.id.phone_delte_imageview://清空输入账号
                mobileEditText.setText("");

                break;
            case R.id.clear_pwd_imageview://清空密码
                pwdEditText.setText(String.valueOf(""));
                break;
            case R.id.login_button://登录按钮

                loginOn();

                break;
            case R.id.showpwd_imageview://显示或隐藏密码
                if (pwdEditText.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                    showPwdImageView.setImageResource(R.mipmap.btn_password_display);
                    pwdEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwdEditText.setSelection(pwdEditText.getText().length());
                } else {
                    showPwdImageView.setImageResource(R.mipmap.btn_password_nodisplay);
                    pwdEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    pwdEditText.setSelection(pwdEditText.getText().length());
                }

                break;
        }
    }

    /**
     * 登录
     */
    private void loginOn() {
        loginButton.setEnabled(false);
        showProgressDialog("正在登陆...");
        HashMap<String, String> loginMap = new HashMap<>();
        loginMap.put("loginName", mobileEditText.getText().toString());
        loginMap.put("password", pwdEditText.getText().toString());
        sendHttpPost(ApiService.LOGIN_UP, loginMap, 10000);
        AppConfig.getInstance().putString("username", mobileEditText.getText().toString());
        AppConfig.getInstance().putString("password", pwdEditText.getText().toString());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mobileEditText.length() > 0 && pwdEditText.length() > 0) {
            loginButton.setClickable(true);
            loginButton.setBackgroundResource(R.drawable.background_newlogin_gobutton_orange);
        } else {
            loginButton.setClickable(false);
            loginButton.setBackgroundResource(R.drawable.background_newlogin_gobutton_gray);
        }

        if (pwdEditText.length() > 0) {
            clearPwdImageView.setVisibility(View.VISIBLE);
        } else {
            clearPwdImageView.setVisibility(View.GONE);
        }
    }

    @Override
    public View[] filterViewByIds() {
        View[] views = {mobileEditText, pwdEditText};
        return views;
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.mobile_edittext, R.id.pwd_edittext};
        return ids;
    }
}
