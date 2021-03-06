package com.ydong.newequip.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.ydong.newequip.R;
import com.ydong.newequip.activity.base.BaseActivity;
import com.ydong.newequip.adapter.MaintainTaskAdapter;
import com.ydong.newequip.config.ApiService;
import com.ydong.newequip.model.MainTainTaskBean;
import com.ydong.newequip.uitls.AppConfig;
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
 * Created by Yanbin on 2018/9/11.
 * 描述:维修工单列表
 */
public class MaintainListAty extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.mTitle)
    TextView mTitle;
    //   @BindView(R.id.text_all_number)
    TextView mTextAll;//
    private MaintainTaskAdapter mAdapter;
    @BindView(R.id.pullToRefreshRecyclerView)
    PullToRefreshRecyclerView mPullToRefreshRecyclerView;
    private List<MainTainTaskBean.DataBean.RowsBean> mLists = new ArrayList<>();
    private static int currentPage = 1;
    private boolean isShowFooter = true;
    private View headerView;


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_maintain_list;
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

    private void initHeaderView() {
        headerView = LayoutInflater.from(baseContext).inflate(R.layout.layout_device_head, null);
        mTextAll = headerView.findViewById(R.id.text_all_number);
        mAdapter.setHeaderView(headerView);
    }

    @Override
    public void aidHandleMessage(int what, int type, Object obj) {
        super.aidHandleMessage(what, type, obj);
        switch (what) {
            case 10004:
                switch (type) {
                    case 10021:
                        hideCustomProgressDialog();
                        LogUtils.d("维修lib", obj);

                        MainTainTaskBean bean = JSON.parseObject(obj.toString(), MainTainTaskBean.class);
                        mTextAll.setText("共有" + bean.getData().getRecords() + "条数据");
                        if (bean.getData().getPage().equals("1")) {
                            mPullToRefreshRecyclerView.onRefreshComplete();
                            mLists = bean.getData().getRows();
                            mAdapter.mList = mLists;
                            if (mLists.size() == 0) {
                                // noInternet.setVisibility(View.VISIBLE);
                                //  mPullToRefreshRecyclerView.setVisibility(View.GONE);
                            } else if (mLists.size() >= bean.getData().getRecords()) {
                                // noInternet.setVisibility(View.GONE);
                                mPullToRefreshRecyclerView.setVisibility(View.VISIBLE);
                                mAdapter.setFooterShow(true);
                                isShowFooter = true;
                                mPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                            } else {
                                // noInternet.setVisibility(View.GONE);
                                mPullToRefreshRecyclerView.setVisibility(View.VISIBLE);
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
                            List<MainTainTaskBean.DataBean.RowsBean> datas = new ArrayList<>();
                            datas = bean.getData().getRows();
                            mLists.addAll(datas);
                            if (datas.size() < 5 && mLists.size() >= bean.getData().getRecords()) {
                                isShowFooter = false;
                            }
                            mAdapter.mList = mLists;
                            if (mLists.size() >= bean.getData().getRecords()) {
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
                //        mPullToRefreshRecyclerView.setVisibility(View.GONE);
                //   noInternet.setVisibility(View.VISIBLE);
                hideCustomProgressDialog();
                mPullToRefreshRecyclerView.onRefreshComplete();
                ToastUtils.showShort("请检查网络");
                break;
        }
    }


    @Override
    public void initData() {
        mTitle.setText(getIntent().getStringExtra("titleName"));
        mPullToRefreshRecyclerView.setVisibility(View.VISIBLE);
        mPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        mAdapter = new MaintainTaskAdapter(MaintainListAty.this, new ArrayList<MainTainTaskBean.DataBean.RowsBean>());
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
                param.put("result", getIntent().getStringExtra("status"));
                param.put("userId", AppConfig.getInstance().getString("userId", ""));
                param.put("page", String.valueOf(currentPage));
                sendHttpGet(ApiService.QUERY_TASK_LIST, param, 10021);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                currentPage++;
                // getCookingSkillVideo(mSelectedTag, currentPage, Add_Tag_Cooking_Skills_Video);
                showProgressDialog("加载中...");
                HashMap<String, String> param = new HashMap<>();
                param.put("keyword", "");
                param.put("rows", "5");
                param.put("result", getIntent().getStringExtra("status"));
                param.put("userId", AppConfig.getInstance().getString("userId", ""));
                param.put("page", String.valueOf(currentPage));
                sendHttpPost(ApiService.QUERY_TASK_LIST, param, 10021);
            }
        });
        currentPage = 1;
        mPullToRefreshRecyclerView.getRefreshableView().setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        showProgressDialog("加载中...");
        HashMap<String, String> param = new HashMap<>();
        param.put("keyword", "");
        param.put("rows", "5");
        param.put("result", getIntent().getStringExtra("status"));
        param.put("userId", AppConfig.getInstance().getString("userId", ""));
        param.put("page", String.valueOf(currentPage));
        sendHttpPost(ApiService.QUERY_TASK_LIST, param, 10021);
        //item跳转事件
        initHeaderView();
    }
}

