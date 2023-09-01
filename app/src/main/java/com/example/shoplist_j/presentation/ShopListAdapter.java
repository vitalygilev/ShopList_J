package com.example.shoplist_j.presentation;

import android.media.tv.TvView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist_j.R;
import com.example.shoplist_j.domain.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder> {

    private List<ShopItem> shopList = new ArrayList<>();
    private OnShopItemClickListener onShopItemClickListener;
    private OnShopItemLongClickListener onShopItemLongClickListener;

    @NonNull
    @Override
    public ShopItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View shopItemView = LayoutInflater.from(parent.getContext()).inflate(
                viewType,
                parent,
                false);
        return new ShopItemViewHolder(shopItemView);
    }

    public void setOnShopItemClickListener(OnShopItemClickListener onShopItemClickListener) {
        this.onShopItemClickListener = onShopItemClickListener;
    }

    public void setOnShopItemLongClickListener(OnShopItemLongClickListener onShopItemLongClickListener) {
        this.onShopItemLongClickListener = onShopItemLongClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemViewHolder holder, int position) {
        ShopItem curShopItem = shopList.get(position);
        holder.tv_name.setText(curShopItem.getText());
        holder.tv_count.setText(Integer.toString(curShopItem.getCount()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onShopItemClickListener != null) {
                    onShopItemClickListener.onShopItemClick(v, curShopItem);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onShopItemLongClickListener != null) {
                    onShopItemLongClickListener.onShopItemLongClick(curShopItem);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public void setShopList(List<ShopItem> shopList) {
        //this.shopList = shopList;
        //notifyDataSetChanged();
        ShopListDiffCallback callback = new ShopListDiffCallback(this.shopList, shopList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);
        diffResult.dispatchUpdatesTo(this);
        this.shopList = shopList;
    }

    @Override
    public int getItemViewType(int position) {
        ShopItem curShopItem = shopList.get(position);
        return curShopItem.isEnabled() ? R.layout.item_shop_enabled : R.layout.item_shop_disabled;
    }


    interface OnShopItemClickListener {
        void onShopItemClick(View view, ShopItem curShopItem);
    }

    interface OnShopItemLongClickListener {
        boolean onShopItemLongClick(ShopItem curShopItem);
    }

    static class ShopItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_count;

        public ShopItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_count = itemView.findViewById(R.id.tv_count);
        }
    }

    public List<ShopItem> getShopList() {
        return shopList;
    }

}
