package com.example.recyclerjsonparsing.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerjsonparsing.R;
import com.example.recyclerjsonparsing.models.AndroidVersion;

import java.util.ArrayList;

/**
 * Created by Sak on 06-Jul-17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    ArrayList<AndroidVersion> android;

    public DataAdapter(ArrayList<AndroidVersion> android){
        this.android = android;
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

    public static class ViewHolder extends RecyclerView.ViewHolder{


        TextView txtViewName;
        TextView txtViewVersion;
        TextView txtViewAPILevel;

        public ViewHolder(View itemView) {
            super(itemView);

            txtViewName = (TextView) itemView.findViewById(R.id.tv_name);
            txtViewVersion = (TextView) itemView.findViewById(R.id.tv_version);
            txtViewAPILevel = (TextView) itemView.findViewById(R.id.tv_api_level);

        }
    }


}
