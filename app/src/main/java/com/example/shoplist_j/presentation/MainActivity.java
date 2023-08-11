package com.example.shoplist_j.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.shoplist_j.R;
import com.example.shoplist_j.domain.ShopItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel = new MainViewModel();

    private static String LOG_STR = "mainViewModelLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel.shopList.observe(this, new Observer<List<ShopItem>>() {
            @Override
            public void onChanged(List<ShopItem> shopItems) {
                Toast.makeText(getApplicationContext(),
                                String.format("List loaded. Length %d ", shopItems.size()) ,
                                Toast.LENGTH_LONG)
                        .show();
                Log.d(LOG_STR, shopItems.toString());
            }
        });

        mainViewModel.getShopList();

    }
}