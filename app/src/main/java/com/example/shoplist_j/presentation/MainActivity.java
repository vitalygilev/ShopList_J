package com.example.shoplist_j.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist_j.R;
import com.example.shoplist_j.domain.ShopItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    private static String LOG_STR = "mainViewModelLog";

    private RecyclerView shopListRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopListRV = findViewById(R.id.shopListRV);
        ShopListAdapter shopListAdapter = new ShopListAdapter();
        shopListRV.setAdapter(shopListAdapter);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.shopList.observe(this, new Observer<List<ShopItem>>() {
            @Override
            public void onChanged(List<ShopItem> shopItems) {
                //mainViewModel.shopList.setValue(shopItems);
                //shopListAdapter.setShopList(shopItems);
                shopListAdapter.submitList(shopItems);
            }
        });

        shopListAdapter.setOnShopItemClickListener(new ShopListAdapter.OnShopItemClickListener() {
            @Override
            public void onShopItemClick(View view, ShopItem curShopItem) {
                Toast.makeText(getApplicationContext(), "Clicked " + curShopItem.toString(),
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
        shopListAdapter.setOnShopItemLongClickListener(new ShopListAdapter.OnShopItemLongClickListener() {
            @Override
            public boolean onShopItemLongClick(ShopItem curShopItem) {
                mainViewModel.changeEnableState(curShopItem);
                return true;
            }
        });

        ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mainViewModel.deleteShopItem(shopListAdapter.getItemByPos(viewHolder.getAdapterPosition()));
            };
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(shopListRV);

        mainViewModel.getShopList();

    }
}