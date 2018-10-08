package com.ydong.newequip.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ydong.newequip.uitls.LogUtils;

import butterknife.ButterKnife;

/**
 * Created by Yanbin on 2018/9/6.
 * 描述:fragment基类
 */
public abstract class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getName();

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getFragmentViewLayout() == 0)
            return super.onCreateView(inflater, container, savedInstanceState);

        try {
            if (rootView == null) {
                rootView = inflater.inflate(getFragmentViewLayout(), null);

            }
            ButterKnife.bind(this, rootView);
            initView();
            initData();
            // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
            return rootView;
        } catch (Throwable e) {
            LogUtils.e(TAG, e);
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        //移除当前视图，防止重复加载相同视图使得程序闪退
        if (rootView != null && rootView.getParent() != null)
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        super.onDestroyView();
    }
    public void initView() {
    }


    public void initData()   {
    }
    public abstract int getFragmentViewLayout();
}
