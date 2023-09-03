package com.example.shoplist_j.presentation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.shoplist_j.domain.ShopItem;

public class ShopItemDiffCallback extends DiffUtil.ItemCallback<ShopItem> {

    public ShopItemDiffCallback() {
    }

    @Override
    public boolean areItemsTheSame(@NonNull ShopItem oldItem, @NonNull ShopItem newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull ShopItem oldItem, @NonNull ShopItem newItem) {
        return oldItem.equals(newItem);
    }
}
