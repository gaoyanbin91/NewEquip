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
import com.ydong.newequip.model.MainTainTaskBean;

import java.util.List;

/**
 * Created by gaoyanbin on 2018/5/28.
 * 描述: 服务请求adapter
 */
public class MaintainTaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_HEADER = 0;
    private final static int TYPE_FOOTER = 1;
    private final static int TYPE_NORMAL = 2;
    private Context mContext;
    public List<MainTainTaskBean.DataBean.RowsBean> mList;
    private boolean isShowFooterView;
    private View mHeaderView;
    private MyItemClick myItemClick;

    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View headerView) {
        this.mHeaderView = headerView;
    }


    public MaintainTaskAdapter(Context mContext, List<MainTainTaskBean.DataBean.RowsBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setFooterShow(boolean isShowFooterView) {
        this.isShowFooterView = isShowFooterView;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new HeaderViewHolder(mHeaderView);
        } else if (viewType == TYPE_FOOTER) {
            return new FooterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_footer_line, parent, false));
        } else {
            return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_maintain_task_list, parent, false));
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
        if (getItemViewType(position) != TYPE_NORMAL) {
            return;
        }
        //在集合中的位置
        int realpos = mHeaderView != null ? position - 1 : position;

        final MainTainTaskBean.DataBean.RowsBean csvm = mList.get(realpos);
        MyViewHolder viewHolder = (MyViewHolder) holder;

        viewHolder.text_name.setText(TextUtils.isEmpty(csvm.getCaseInfo().getEquipName()) ? String.valueOf("") : csvm.getCaseInfo().getEquipName());
        viewHolder.text_creat_time.setText(TextUtils.isEmpty(csvm.getAcceptLog().getCreateTime()) ? String.valueOf("派单时间：") : "派单时间：" + csvm.getAcceptLog().getCreateTime());
        if (csvm.getCaseInfo().getResult() == 0) {
            viewHolder.text_status.setText("待接收");
        } else if (csvm.getCaseInfo().getResult() == 2) {
            viewHolder.text_status.setText("处理中");
        }

        viewHolder.text_que_detail.setText(TextUtils.isEmpty(csvm.getCaseInfo().getNote()) ? String.valueOf("问题描述：") : "问题描述：" + csvm.getCaseInfo().getNote());

        // viewHolder.text_postion.setText(TextUtils.isEmpty(csvm.getPosition()) ? String.valueOf("") : csvm.getPosition());
        if (csvm.getCaseInfo().getResult() == 0) {
            viewHolder.text_todo.setBackgroundResource(R.drawable.item_task_red_bg);
            viewHolder.text_todo.setTextColor(mContext.getResources().getColor(R.color.red));
            viewHolder.text_todo.setText("  接收任务  ");

        } else if (csvm.getCaseInfo().getResult() == 1) {
            viewHolder.text_todo.setBackgroundResource(R.drawable.item_task_gray_bg);
            viewHolder.text_todo.setTextColor(mContext.getResources().getColor(R.color.gray5));
            viewHolder.text_get_time.setText(TextUtils.isEmpty(csvm.getAcceptLog().getOperateTime()) ? String.valueOf("接单时间：") : "接单时间：" + csvm.getAcceptLog().getOperateTime());
            viewHolder.text_person.setText(TextUtils.isEmpty(csvm.getAcceptLog().getOperaterName()) ? String.valueOf("接单人：") : "接单人：" + csvm.getAcceptLog().getOperaterName());
            viewHolder.text_todo.setText("  到场处理  ");

        } else if (csvm.getCaseInfo().getResult() == 2) {
            viewHolder.text_todo.setBackgroundResource(R.drawable.item_task_gray_bg);
            viewHolder.text_todo.setTextColor(mContext.getResources().getColor(R.color.gray5));
            viewHolder.text_get_time.setText(TextUtils.isEmpty(csvm.getAcceptLog().getCreateTime()) ? String.valueOf("接单时间：") : "接单时间：" + csvm.getHandleLog().getCreateTime());
            viewHolder.text_person.setText(TextUtils.isEmpty(csvm.getPresentLog().getOperaterName()) ? String.valueOf("接单人：") : "接单人：" + csvm.getPresentLog().getOperaterName());
            viewHolder.text_todo.setText("  处理任务  ");

        } else if (csvm.getCaseInfo().getResult() == 401) {
//            viewHolder.text_todo.setBackgroundResource(R.drawable.item_task_gray_bg);
//          viewHolder.text_todo.setTextColor(mContext.getResources().getColor(R.color.gray5));
//            viewHolder.text_get_time.setText(TextUtils.isEmpty(csvm.getAcceptLog().getCreateTime()) ? String.valueOf("接单时间：") : "接单时间：" + csvm.getHandleLog().getCreateTime());
//            viewHolder.text_person.setText(TextUtils.isEmpty(csvm.getPresentLog().getOperaterName()) ? String.valueOf("接单人：") : "接单人：" + csvm.getPresentLog().getOperaterName());
            //  viewHolder.text_todo.setText("  处理任务  ");

        }

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
        private TextView text_name, text_creat_time, text_status, text_que_detail,
                text_todo, text_get_time, text_person;

        public MyViewHolder(View itemView) {
            super(itemView);
            rootLayout = (LinearLayout) itemView.findViewById(R.id.rootLayout);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_creat_time = (TextView) itemView.findViewById(R.id.text_creat_time);
            text_status = itemView.findViewById(R.id.text_status);
            text_que_detail = itemView.findViewById(R.id.text_que_detail);

            text_todo = itemView.findViewById(R.id.text_todo);
            text_get_time = itemView.findViewById(R.id.text_get_time);
            text_person = itemView.findViewById(R.id.text_person);
            // text_get_time = itemView.findViewById(R.id.text_get_time);
        }
    }

    public interface MyItemClick {
        void onItemClick(MainTainTaskBean.DataBean.RowsBean model);
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
