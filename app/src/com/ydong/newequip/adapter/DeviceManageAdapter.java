package com.ydong.newequip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ydong.newequip.R;
import com.ydong.newequip.model.DeviceManageBean;

import java.util.List;

/**
 * Created by gaoyanbin on 2018/5/28.
 * 描述: 服务请求adapter
 */
public class DeviceManageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_HEADER = 0;
    private final static int TYPE_FOOTER = 1;
    private final static int TYPE_NORMAL = 2;

    private Context mContext;
    public List<DeviceManageBean.RowsBean> mList;
    private boolean isShowFooterView;

    private MyItemClick myItemClick;
    private View mHeaderView;

    public DeviceManageAdapter(Context mContext, List<DeviceManageBean.RowsBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }
    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View headerView) {
        this.mHeaderView = headerView;
    }

    public void setFooterShow(boolean isShowFooterView) {
        this.isShowFooterView = isShowFooterView;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new HeaderViewHolder(mHeaderView);
        } else   if (viewType == TYPE_FOOTER) {
            return new FooterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_footer_line, parent, false));
        } else {
            return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_device_list, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView != null) {
            if (position == 0) {
                return TYPE_HEADER;
            } else if (position == mList.size() + 1) {
                return TYPE_FOOTER;
            } else {
                return TYPE_NORMAL;
            }
        } else {
            if (position == mList.size()) {
                return TYPE_FOOTER;
            } else {
                return TYPE_NORMAL;
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) != TYPE_NORMAL){
            return;
        }

        //在集合中的位置
        int realpos = mHeaderView != null ? position - 1 : position;

        final DeviceManageBean.RowsBean csvm = mList.get(realpos);
        MyViewHolder viewHolder = (MyViewHolder) holder;

        viewHolder.text_name.setText(TextUtils.isEmpty(csvm.getName()) ? String.valueOf("") : csvm.getName());
        viewHolder.text_num.setText(TextUtils.isEmpty(csvm.getCode())? String.valueOf("") : csvm.getCode());
        viewHolder.text_type.setText(TextUtils.isEmpty(csvm.getType()) ? String.valueOf("") : csvm.getType());
        viewHolder.text_profession.setText( TextUtils.isEmpty(csvm.getMajorName()) ? String.valueOf("") : csvm.getMajorName());
        viewHolder.text_region.setText( TextUtils.isEmpty(csvm.getRegion()) ? String.valueOf("") : csvm.getRegion());
        viewHolder.text_postion.setText(TextUtils.isEmpty(csvm.getPosition()) ? String.valueOf("") : csvm.getPosition());
        viewHolder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myItemClick != null) {
                    myItemClick.onItemClick(csvm);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (isShowFooterView) {
            return mHeaderView == null ? mList.size() + 1 : mList.size() + 2;
        } else {
            return mHeaderView == null ? mList.size() : mList.size() + 1;
        }
    }

    public void setMyItemClick(MyItemClick myItemClick) {
        this.myItemClick = myItemClick;
    }



    private class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout rootLayout;
        private TextView text_name,text_num,text_type,text_profession,text_region,text_postion;

        public MyViewHolder(View itemView) {
            super(itemView);
            rootLayout = (LinearLayout) itemView.findViewById(R.id.rootLayout);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_num = (TextView) itemView.findViewById(R.id.text_num);
            text_type = itemView.findViewById(R.id.text_type);
            text_profession = itemView.findViewById(R.id.text_profession);
            text_region = itemView.findViewById(R.id.text_region);
            text_postion = itemView.findViewById(R.id.text_postion);
        }
    }

    public interface MyItemClick {
        void onItemClick(DeviceManageBean.RowsBean model);
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
