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
import com.ydong.newequip.model.InspectorBean;

import java.util.List;

/**
 * Created by gaoyanbin on 2018/5/28.
 * 描述:
 */
public class InspectorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_HEADER = 0;
    private final static int TYPE_FOOTER = 1;
    private final static int TYPE_NORMAL = 2;
    private Context mContext;
    public List<InspectorBean.DataBean.RowsBean> mList;
    private boolean isShowFooterView;
    private View mHeaderView;
    private MyItemClick myItemClick;
    private MyItemButtonClick myItemButtonClick;

    public MyItemButtonClick getMyItemButtonClick() {
        return myItemButtonClick;
    }

    public void setMyItemButtonClick(MyItemButtonClick myItemButtonClick) {
        this.myItemButtonClick = myItemButtonClick;
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View headerView) {
        this.mHeaderView = headerView;
    }


    public InspectorAdapter(Context mContext, List<InspectorBean.DataBean.RowsBean> mList) {
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
            return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_inspector_list, parent, false));
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

        final InspectorBean.DataBean.RowsBean csvm = mList.get(realpos);
        MyViewHolder viewHolder = (MyViewHolder) holder;

        viewHolder.text_name.setText(TextUtils.isEmpty(csvm.getRecordName()) ? String.valueOf("") : csvm.getRecordName());

        viewHolder.text_record_code.setText(TextUtils.isEmpty(csvm.getRecordCode()) ? String.valueOf("") : csvm.getRecordCode());
        viewHolder.text_time_get.setText(TextUtils.isEmpty(csvm.getRecordTime()) ? String.valueOf("接单时间：") : "接单时间：" + csvm.getRecordTime());
        viewHolder.text_dispatch_time.setText(TextUtils.isEmpty(csvm.getCreateTime()) ? String.valueOf("派单时间：") : "派单时间：" + csvm.getCreateTime());

        viewHolder.text_get_name.setText(TextUtils.isEmpty(csvm.getRecordName()) ? String.valueOf("接单人：") : "接单人：" + csvm.getRecorderName());


        if (csvm.getResult() == 1) {
            viewHolder.text_status.setText("状态：巡检中");
        } else if (csvm.getResult() == 2) {
            viewHolder.text_status.setText("状态：已巡检");
        }


        // viewHolder.text_postion.setText(TextUtils.isEmpty(csvm.getPosition()) ? String.valueOf("") : csvm.getPosition());
        if (csvm.getResult() == 0) {
            viewHolder.text_todo.setBackgroundResource(R.drawable.item_task_red_bg);
            viewHolder.text_todo.setTextColor(mContext.getResources().getColor(R.color.red));
            viewHolder.text_todo.setText("  接收任务  ");

        } else if (csvm.getResult() == 1) {
            viewHolder.text_todo.setBackgroundResource(R.drawable.item_task_gray_bg);
            viewHolder.text_todo.setTextColor(mContext.getResources().getColor(R.color.gray5));
            viewHolder.text_todo.setText("  处理任务  ");

        } else if (csvm.getResult() == 2) {
//            viewHolder.text_todo.setBackgroundResource(R.drawable.item_task_gray_bg);
//            viewHolder.text_todo.setTextColor(mContext.getResources().getColor(R.color.gray5));
//            viewHolder.text_todo.setText("  处理任务  ");

        }
        viewHolder.text_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myItemButtonClick!=null){
                    myItemButtonClick.onItemButtonClick(csvm);
                }
            }
        });
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
        private TextView text_name, text_record_code, text_get_name, text_dispatch_time,
                text_status, text_todo,text_time_get;

        public MyViewHolder(View itemView) {
            super(itemView);
            rootLayout = (LinearLayout) itemView.findViewById(R.id.rootLayout);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_record_code = (TextView) itemView.findViewById(R.id.text_record_code);


            text_get_name = itemView.findViewById(R.id.text_get_name);
            text_dispatch_time = itemView.findViewById(R.id.text_dispatch_time);


            text_status = itemView.findViewById(R.id.text_status);

            text_todo = itemView.findViewById(R.id.text_todo);
              text_time_get = itemView.findViewById(R.id.text_time_get);
        }
    }

    public interface MyItemClick {
        void onItemClick(InspectorBean.DataBean.RowsBean model);
    }
    public interface MyItemButtonClick {
        void onItemButtonClick(InspectorBean.DataBean.RowsBean model);
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
