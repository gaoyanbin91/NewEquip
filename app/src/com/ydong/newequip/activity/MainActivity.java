package com.ydong.newequip.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.fragment.MessageFragment;
import com.ydong.newequip.fragment.MineFragment;
import com.ydong.newequip.fragment.PersonsFragment;
import com.ydong.newequip.fragment.TodoFragment;
import com.ydong.newequip.fragment.WorkFragment;
import com.ydong.newequip.runtimepermissions.PermissionsManager;
import com.ydong.newequip.runtimepermissions.PermissionsResultAction;
import com.ydong.newequip.ui.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    @BindView(R.id.msgTip)
    FrameLayout mFrameLayout;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;



    private String txvMenu[];
    private int intImageViewArray2[];
    /**
     * 定义数组来存放Fragment界面
     */
    private Class fragmentArray[];

    private List<View> badgeTargetList;


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        requestPermissions();


    }
    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(MainActivity.this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
            }

            @Override
            public void onDenied(String permission) {
            }
        });
    }

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setSystemBar(true);
        intImageViewArray2 = new int[]{R.drawable.tab_message_bg, R.drawable.tab_person_bg, R.drawable.tab_work_bg, R.drawable.tab_todo_bg, R.drawable.tab_my_bg};
        fragmentArray = new Class[]{MessageFragment.class, PersonsFragment.class, WorkFragment.class, TodoFragment.class, MineFragment.class};
        txvMenu = new String[]{getString(R.string.text_menu_message),
                getString(R.string.text_menu_persons),
                getString(R.string.text_menu_work),
                getString(R.string.text_menu_godo),
                getString(R.string.text_menu_mine)};
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = intImageViewArray2.length;

        tabhost.setup(this, fragmentManager, R.id.realtabcontent);
        badgeTargetList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 将Tab按钮添加进Tab选项卡中
            View view = getTabItemView(i);
            badgeTargetList.add(view);
            tabhost.addTab(tabhost.newTabSpec(String.valueOf(i)).setIndicator(view), fragmentArray[i], null);
        }

        tabhost.getTabWidget().setDividerDrawable(getResources().getDrawable(R.color.white));
        tabhost.setOnTabChangedListener(this);
        tabhost.setCurrentTab(2);
    }
    private View getTabItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_tab_item, null);
        ImageView mImageView = (ImageView) view.findViewById(R.id.icon);
        TextView txv_menu = (TextView) view.findViewById(R.id.txv_menu);
        txv_menu.setText(txvMenu[i]);
        mImageView.setImageResource(intImageViewArray2[i]);
        return view;
    }

    @Override
    public void onTabChanged(String tabId) {

    }
}
