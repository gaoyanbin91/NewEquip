package com.ydong.newequip.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.adapter.DeviceManageAdapter;
import com.ydong.newequip.config.ApiService;
import com.ydong.newequip.model.DeviceManageBean;
import com.ydong.newequip.uitls.LogUtils;
import com.ydong.newequip.uitls.ToastUtils;
import com.ydong.newequip.view.mydivider.MyDecoration0_25dp;
import com.ydong.newequip.view.pulltorefresh.PullToRefreshBase;
import com.ydong.newequip.view.pulltorefresh.extral.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Yanbin on 2018/9/10.
 * 描述:设备管理页面
 */
public class DeviceManageActivity extends BaseActivity {
    @BindView(R.id.pullToRefreshRecyclerView)
    PullToRefreshRecyclerView mPullToRefreshRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private static int currentPage = 1;
    private List<DeviceManageBean.RowsBean> mLists = new ArrayList<>();
    private DeviceManageAdapter mAdapter;
    private boolean isShowFooter = true;
   // @BindView(R.id.text_all_number)
    TextView textAllNumber;
    private View headerView;
    private EditText mEditText;
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_device_manage;
    }

    private void initHeaderView() {
        headerView = LayoutInflater.from(baseContext).inflate(R.layout.layout_device_head, null);
        textAllNumber = headerView.findViewById(R.id.text_all_number);
        mEditText = headerView.findViewById(R.id.text_contact);
        mAdapter.setHeaderView(headerView);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ToastUtils.showShort(s.toString());
//                showProgressDialog("加载中...");
//                HashMap<String, String> param = new HashMap<>();
//                param.put("keyword", s.toString());
//                param.put("rows", "5");
//                //    param.put("sort", "createTime");
//                //  param.put("fjCustomerld", AppConfig.getInstance().getString("fjCustomerId", ""));
//                param.put("page", String.valueOf(currentPage));
//                sendHttpGet(ApiService.QUERY_DRVICE_MANAGES, param, 10011);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void aidHandleMessage(int what, int type, Object obj) {
        super.aidHandleMessage(what, type, obj);
        switch (what) {
            case 10004:
                switch (type) {
                    case 10011:
                        hideCustomProgressDialog();
                        LogUtils.d("管理lib", obj);

                        DeviceManageBean bean = JSON.parseObject(obj.toString(), DeviceManageBean.class);
                        textAllNumber.setText("共有" + bean.getRecords() + "条数据");
                        if (bean.getPage().equals("1")) {
                            mPullToRefreshRecyclerView.onRefreshComplete();
                            mLists = bean.getRows();
                            mAdapter.mList = mLists;
                            if (mLists.size() == 0) {
                                // noInternet.setVisibility(View.VISIBLE);
                                mPullToRefreshRecyclerView.setVisibility(View.GONE);
                            } else if (mLists.size() >= bean.getRecords()) {
                                // noInternet.setVisibility(View.GONE);
                                mPullToRefreshRecyclerView.setVisibility(View.VISIBLE);
                                mAdapter.setFooterShow(true);
                                isShowFooter = true;
                                mPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                            } else {
                                // noInternet.setVisibility(View.GONE);
                            //    mPullToRefreshRecyclerView.setVisibility(View.VISIBLE);
                                mAdapter.setFooterShow(false);
                                isShowFooter = false;
                                mPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
                            }
                            mAdapter.notifyDataSetChanged();
                            mPullToRefreshRecyclerView.getRefreshableView().scrollToPosition(0);
                            return;
                        }
                        if (currentPage > 1) {
                            mPullToRefreshRecyclerView.onRefreshComplete();
                            List<DeviceManageBean.RowsBean> datas = new ArrayList<>();
                            datas = bean.getRows();
                            mLists.addAll(datas);
                            if (datas.size() < 5 && mLists.size() >= bean.getRecords()) {
                                isShowFooter = false;
                            }
                            mAdapter.mList = mLists;
                            if (mLists.size() >= bean.getRecords()) {
                                mAdapter.setFooterShow(true);
                                mPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                            } else {
                                mAdapter.setFooterShow(false);
                                mPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
                            }
                            mAdapter.notifyDataSetChanged();
                        }
                        break;
                }

                break;
            case 10003:
              //  mPullToRefreshRecyclerView.setVisibility(View.GONE);
                //   noInternet.setVisibility(View.VISIBLE);
                hideCustomProgressDialog();
                mPullToRefreshRecyclerView.onRefreshComplete();
                // hideCustomProgressDialog();
                ToastUtils.showShort("请检查网络");
                break;

        }
    }

    @Override
    public void initData() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mPullToRefreshRecyclerView.setVisibility(View.VISIBLE);
        mPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        mAdapter = new DeviceManageAdapter(DeviceManageActivity.this, new ArrayList<DeviceManageBean.RowsBean>());
        MyDecoration0_25dp divider = new MyDecoration0_25dp(this, MyDecoration0_25dp.VERTICAL_LIST);
        divider.setDivider(R.drawable.divider_transparent_0_25dp);
        mPullToRefreshRecyclerView.getRefreshableView().addItemDecoration(divider);
        mPullToRefreshRecyclerView.getRefreshableView().setAdapter(mAdapter);
        mPullToRefreshRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                currentPage = 1;
                showProgressDialog("加载中...");
                HashMap<String, String> param = new HashMap<>();
                param.put("keyword", "");
                param.put("rows", "5");
                //    param.put("sort", "createTime");
                //  param.put("fjCustomerld", AppConfig.getInstance().getString("fjCustomerId", ""));
                param.put("page", String.valueOf(currentPage));
                sendHttpGet(ApiService.QUERY_DRVICE_MANAGES, param, 10011);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                currentPage++;
                // getCookingSkillVideo(mSelectedTag, currentPage, Add_Tag_Cooking_Skills_Video);
                showProgressDialog("加载中...");
                HashMap<String, String> param = new HashMap<>();
                param.put("keyword", "");
                param.put("rows", "5");
                //    param.put("sort", "createTime");
                //  param.put("fjCustomerld", AppConfig.getInstance().getString("fjCustomerId", ""));
                param.put("page", String.valueOf(currentPage));
                sendHttpPost(ApiService.QUERY_DRVICE_MANAGES, param, 10011);
            }
        });
        currentPage = 1;
        mPullToRefreshRecyclerView.getRefreshableView().setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        showProgressDialog("加载中...");
        HashMap<String, String> param = new HashMap<>();
        param.put("keyword", "");
        param.put("rows", "5");
        //    param.put("sort", "createTime");
        //  param.put("fjCustomerld", AppConfig.getInstance().getString("fjCustomerId", ""));
        param.put("page", String.valueOf(currentPage));
        sendHttpPost(ApiService.QUERY_DRVICE_MANAGES, param, 10011);
        //item跳转事件
        mAdapter.setMyItemClick(new DeviceManageAdapter.MyItemClick() {
            @Override
            public void onItemClick(DeviceManageBean.RowsBean model) {
                Intent i = new Intent(baseContext, DeviceManageDetailAty.class);
                i.putExtra("code", model.getCode());
                i.putExtra("name", model.getName());
                i.putExtra("type", model.getType());
                i.putExtra("major", model.getMajorName());
                i.putExtra("region", model.getRegion());
                i.putExtra("postion", model.getPosition());
                startActivity(i);
            }
        });
        initHeaderView();
    }
}

