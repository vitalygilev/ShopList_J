package com.example.shoplist_j.domain;

import java.util.List;
import java.util.stream.Stream;

public interface ShopListRepository {

    public List<ShopItem> getShopList();
    public ShopItem getShopItem(int id);
    public void editShopItem(ShopItem shopItem);
    public void deleteShopItem(int id);
    public void addShopItem(ShopItem shopItem);

}
