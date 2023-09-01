package com.example.shoplist_j.presentation;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.shoplist_j.domain.ShopItem;

import java.util.List;

public class ShopListDiffCallback extends DiffUtil.Callback {

    private List<ShopItem> oldList;
    private List<ShopItem> newList;

    public ShopListDiffCallback(List<ShopItem> oldList, List<ShopItem> newList) {
        super();
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
