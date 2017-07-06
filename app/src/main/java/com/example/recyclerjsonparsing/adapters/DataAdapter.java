package com.example.recyclerjsonparsing.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerjsonparsing.R;
import com.example.recyclerjsonparsing.interfaces.RecyclerClickListener;
import com.example.recyclerjsonparsing.models.AndroidVersion;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sak on 06-Jul-17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<AndroidVersion> android;
    private RecyclerClickListener recyclerClickListener;

    public DataAdapter(List<AndroidVersion> android, RecyclerClickListener recyclerClickListener){
        this.android = android;
        this.recyclerClickListener = recyclerClickListener;
    }



    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.txtViewName.setText(android.get(position).getName());
        holder.txtViewVersion.setText(android.get(position).getVersion());
        holder.txtViewAPILevel.setText(android.get(position).getApi());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_name)
        TextView txtViewName;

        @BindView(R.id.tv_version)
        TextView txtViewVersion;

        @BindView(R.id.tv_api_level)
        TextView txtViewAPILevel;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerClickListener.onItemClicked(android.get(getLayoutPosition()));
                }
            });

        }
    }


}
