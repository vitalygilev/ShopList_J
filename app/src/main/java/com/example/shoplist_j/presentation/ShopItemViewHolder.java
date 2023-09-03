package com.example.shoplist_j.presentation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist_j.R;

public class ShopItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView tv_name;
        public final TextView tv_count;

        public ShopItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_count = itemView.findViewById(R.id.tv_count);
        }
    }

