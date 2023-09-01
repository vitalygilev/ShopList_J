package com.example.shoplist_j.presentation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.shoplist_j.domain.ShopItem;

public class ShopItemDiffCallback extends DiffUtil.ItemCallback<ShopItem> {

    ShopItem lastItem;
    ShopItem curItem;

    public ShopItemDiffCallback(ShopItem lastItem, ShopItem curItem) {
        this.lastItem = lastItem;
        this.curItem = curItem;
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
