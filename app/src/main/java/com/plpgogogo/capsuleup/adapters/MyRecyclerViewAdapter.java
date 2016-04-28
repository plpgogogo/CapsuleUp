package com.plpgogogo.capsuleup.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.plpgogogo.capsuleup.R;
import com.plpgogogo.capsuleup.database.Data;

import java.util.List;

/**
 * Created by 大舅哥 on 2016/4/28.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Data> datas;

    public MyRecyclerViewAdapter(Context context, List<Data> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.content_data, null, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Data data = datas.get(position);
        holder.tvDate.setText("￥ " + data.getTame());
        holder.tvMoney.setText(data.getTame());
        if(data.getPicture() != null){
            holder.memoIndicator_1.setImageDrawable(mContext.getDrawable(R.drawable.ic_insert_photo_black_48dp));
            if(data.getTape() != null){
                holder.memoIndicator_2.setImageDrawable(mContext.getDrawable(R.drawable.ic_mic_black_48dp));
            }
        }
        else{
            if(data.getTape() != null){
                holder.memoIndicator_1.setImageDrawable(mContext.getDrawable(R.drawable.ic_mic_black_48dp));
            }
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgType, memoIndicator_1, memoIndicator_2;
        private TextView tvType, tvDate, tvMoney;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgType = (ImageView) itemView.findViewById(R.id.imgType);
            memoIndicator_1 = (ImageView) itemView.findViewById(R.id.memoIndicator_1);
            memoIndicator_2 = (ImageView) itemView.findViewById(R.id.memoIndicator_2);
            tvType = (TextView) itemView.findViewById(R.id.tvType);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvMoney = (TextView) itemView.findViewById(R.id.tvMoney);
        }
    }
}
