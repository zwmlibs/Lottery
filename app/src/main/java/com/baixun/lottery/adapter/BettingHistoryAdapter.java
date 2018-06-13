package com.baixun.lottery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baixun.lottery.R;
import com.baixun.lottery.bean.Win;
import com.baixun.lottery.utils.OnItemClickListner;

import java.util.ArrayList;

/**
 * 开奖记录
 */

public class BettingHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Win> data;
    private Context context;
    private OnItemClickListner listener;

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private View mHeaderView;

    public BettingHistoryAdapter(Context context, ArrayList<Win> data, OnItemClickListner listener) {
        this.data = data;
        this.context = context;
        this.listener = listener;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? data.size() : data.size() + 1;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(holder);
        if (holder instanceof ItemViewHolder) {
            Win win = data.get(pos);
            ((ItemViewHolder) holder).txtNumberOfPeriods.setText("第60期");
            ((ItemViewHolder) holder).txtPrizeNumber.setText("6 9 8 7 5");
            ((ItemViewHolder) holder).txtThousands.setText("大双");
            ((ItemViewHolder) holder).txtOnePlace.setText("小双");
            ((ItemViewHolder) holder).txtHowToPlay.setText("前二");

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new Holder(mHeaderView);
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_betting_history, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListner(v,0);
            }
        });
        return new ItemViewHolder(view);
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtNumberOfPeriods;
        TextView txtPrizeNumber;
        TextView txtThousands;
        TextView txtOnePlace;
        TextView txtHowToPlay;

        public ItemViewHolder(View view) {
            super(view);
            txtNumberOfPeriods = (TextView) view.findViewById(R.id.txtNumberOfPeriods);
            txtPrizeNumber = (TextView) view.findViewById(R.id.txtPrizeNumber);
            txtThousands = (TextView) view.findViewById(R.id.txtThousands);
            txtOnePlace = (TextView) view.findViewById(R.id.txtOnePlace);
            txtHowToPlay = (TextView) view.findViewById(R.id.txtHowToPlay);
        }
    }
}
