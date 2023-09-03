package com.example.shoplist_j.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoplist_j.data.ShopListRepositoryImpl;
import com.example.shoplist_j.domain.DeleteShopItemUseCase;
import com.example.shoplist_j.domain.EditShopItemUseCase;
import com.example.shoplist_j.domain.GetShopItemUseCase;
import com.example.shoplist_j.domain.GetShopListUseCase;
import com.example.shoplist_j.domain.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private ShopListRepositoryImpl repository;

    private GetShopListUseCase getShopListUseCase;
    private EditShopItemUseCase editShopItemUseCase;
    private DeleteShopItemUseCase deleteShopItemUseCase;

    public MutableLiveData<List<ShopItem>> shopList = new MutableLiveData<>();

    public MainViewModel() {

        repository = ShopListRepositoryImpl.getInstance();
        getShopListUseCase = new GetShopListUseCase(repository);
        editShopItemUseCase = new EditShopItemUseCase(repository);
        deleteShopItemUseCase = new DeleteShopItemUseCase(repository);

    }

    public void getShopList() {
        shopList.setValue(getShopListUseCase.getShopList());
    }

    public void deleteShopItem(ShopItem shopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem.getId());
        getShopList();
    }

    public void deleteShopItemById(int id) {
        deleteShopItemUseCase.deleteShopItem(id);
        getShopList();
    }

    public void editShopItemUseCase(ShopItem shopItem) {
        editShopItemUseCase.editShopItem(shopItem);
        getShopList();
    }

    public void changeEnableState(ShopItem shopItem) {
        ShopItem newShopItem = new ShopItem(shopItem);
        newShopItem.setEnabled(!newShopItem.isEnabled());
        editShopItemUseCase(newShopItem);
        getShopList();
    }
}
