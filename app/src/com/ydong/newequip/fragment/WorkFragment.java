package com.ydong.newequip.fragment;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.ydong.newequip.R;
import com.ydong.newequip.activity.DeviceManageActivity;
import com.ydong.newequip.activity.EvenAddActivity;
import com.ydong.newequip.activity.MaintainManageActivity;
import com.ydong.newequip.activity.MeterManageActivity;
import com.ydong.newequip.fragment.base.BaseFragment;
import com.ydong.newequip.uitls.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Yanbin on 2018/9/6.
 * 描述:工作
 */
public class WorkFragment extends BaseFragment {
    @BindView(R.id.main_content)
    ConstraintLayout main_content;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.gv_home_model)
    GridView gvModel;
    private SimpleAdapter mAdapter;

    @Override
    public int getFragmentViewLayout() {
        return R.layout.fragment_home_work;
    }

    @Override
    public void initView() {
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ToastUtils.showShort("搜索");
            }
        });
        gvModel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), DeviceManageActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), MaintainManageActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), MeterManageActivity.class));

                        break;
                    case 3:
                        ToastUtils.showShort("完善中...");
                        break;


                }
            }
        });
    }

    @OnClick({R.id.rl_add,R.id.rl_sao,R.id.rl_sign})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_add:
                startActivity(new Intent(getActivity(), EvenAddActivity.class));
                break;
            case R.id.rl_sao:
                ToastUtils.showShort("扫一扫");
                break;
            case R.id.rl_sign:
                ToastUtils.showShort("考勤打卡");
                break;

        }
    }

    @Override
    public void initData() {

        //设置主页功能模块
        mAdapter = new SimpleAdapter(getActivity(), getDatas(), R.layout.main_item, new String[]{"picture", "name"}, new int[]{R.id.iv_model_image, R.id.tv_model_name});
        gvModel.setAdapter(mAdapter);
    }

    /**
     * 得到菜单数据
     *
     * @return
     */
    private List<Map<String, Object>> getDatas() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map = new HashMap<>();
        map.put("picture", R.mipmap.ic_launcher);
        map.put("name", getString(R.string.home_1));
        list.add(map);
        map = new HashMap<>();
        map.put("picture", R.mipmap.ic_launcher);
        map.put("name", getString(R.string.home_2));
        list.add(map);
        map = new HashMap<>();
        map.put("picture", R.mipmap.ic_launcher);
        map.put("name", getString(R.string.home_3));
        list.add(map);
        map = new HashMap<>();
        map.put("picture", R.mipmap.ic_launcher);
        map.put("name", getString(R.string.home_4));
        list.add(map);
//        map = new HashMap<>();
//        map.put("picture", R.mipmap.ic_launcher);
//        map.put("name", getString(R.string.home_5));
//        list.add(map);

        int size = list.size();
        if (size % 4 != 0) {
            for (int i = 0; i < 4 - size % 4; i++) {
                map = new HashMap<>();
                map.put("picture", "");
                map.put("name", "");
                list.add(map);
            }
        }

        return list;
    }
}
