package com.example.ismaelalvarez.recyclerviewneastedexample;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Jeffrey Liu on 3/21/16.
 */
public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TShirtFeature> mList;
    private OnItemClickListener mItemClickListener;
    private String name;
    public HorizontalRecyclerAdapter(List<TShirtFeature> list,String name) {
        this.mList = list;
        this.name = name;
    }

    private class CellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView color;
        private TextView size;
        private TextView name;

        public CellViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            color = itemView.findViewById(R.id.color);
            size = itemView.findViewById(R.id.size);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemLongClick(view, getLayoutPosition());
                return true;
            }
            return false;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            default: {
                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_list_item_type_title, viewGroup, false);
                return new CellViewHolder(v1);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            default: {

                CellViewHolder cellViewHolder = (CellViewHolder) viewHolder;
                cellViewHolder.name.setText("Name : "+ name);
                cellViewHolder.color.setText("Color : " + mList.get(position).getColor());
                cellViewHolder.size.setText("Size : " + mList.get(position).getSize());
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    // for both short and long click
    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}