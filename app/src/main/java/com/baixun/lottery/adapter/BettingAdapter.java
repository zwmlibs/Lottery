package com.baixun.lottery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baixun.lottery.R;
import com.baixun.lottery.bean.Dragon;
import com.baixun.lottery.utils.LogUtils;
import com.baixun.lottery.utils.OnItemClickListner;
import com.baixun.lottery.widget.CustomGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description 描述
 * Created by 张伟明 on 2017/5/18.
 */

public class BettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Dragon> data;
    private OnItemClickListner onItemClickListner;

    public BettingAdapter(Context context, ArrayList<Dragon> data,OnItemClickListner onItemClickListner) {
        this.context = context;
        this.data = data;
        this.onItemClickListner = onItemClickListner;
    }

    public void refresh(ArrayList<Dragon> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder) {
            final Dragon dragon = data.get(position);
            ((ItemViewHolder) holder).txtHowToPlay.setText("万位");

            ((ItemViewHolder) holder).txtEmpty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListner.onItemClickListner(view,position);
                }
            });

            List<Integer> data = new ArrayList<>();
            data.add(0);
            data.add(1);
            data.add(2);
            data.add(3);
            data.add(4);
            data.add(5);
            data.add(6);
            data.add(7);
            data.add(8);
            data.add(9);
            BettingBallAdapter adapter = new BettingBallAdapter(context,data);
            ((ItemViewHolder) holder).gvBettingBall.setAdapter(adapter);
            ((ItemViewHolder) holder).gvBettingBall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    LogUtils.log("position:" + i);
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_betting, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ItemViewHolder(view);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtHowToPlay;
        TextView txtEmpty;
        TextView txtEven;
        TextView txtSingular;
        TextView txtSmall;
        TextView txtBig;
        TextView txtAll;
        GridView gvBettingBall;

        public ItemViewHolder(View view) {
            super(view);
            txtHowToPlay = (TextView) view.findViewById(R.id.txtHowToPlay);
            txtEmpty = (TextView) view.findViewById(R.id.txtEmpty);
            txtEven = (TextView) view.findViewById(R.id.txtEven);
            txtSingular = (TextView) view.findViewById(R.id.txtSingular);
            txtSmall = (TextView) view.findViewById(R.id.txtSmall);
            txtBig = (TextView) view.findViewById(R.id.txtBig);
            txtAll = (TextView) view.findViewById(R.id.txtAll);
            gvBettingBall = (CustomGridView) view.findViewById(R.id.gvBettingBall);
        }
    }
}
