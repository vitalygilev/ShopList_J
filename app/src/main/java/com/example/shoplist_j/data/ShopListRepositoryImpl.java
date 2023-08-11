package com.example.shoplist_j.data;

import com.example.shoplist_j.domain.ShopItem;
import com.example.shoplist_j.domain.ShopListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShopListRepositoryImpl implements ShopListRepository {

    private static ShopListRepositoryImpl shopListRepositoryImpl;

    private List<ShopItem> shopList = new ArrayList<>();

    private int autoIncrementId = 0;

    private ShopListRepositoryImpl() {
    }

    public static ShopListRepositoryImpl getInstance() {
        if (shopListRepositoryImpl == null) {
            shopListRepositoryImpl = new ShopListRepositoryImpl();
        }
        return shopListRepositoryImpl;
    }

    @Override
    public List<ShopItem> getShopList() {
        addShopItem(new ShopItem("Bobber 1", 1, false));
        addShopItem(new ShopItem("Bobber 2", 2, false));
        addShopItem(new ShopItem("Bobber 3", 3, false));
        return new ArrayList<ShopItem>(shopList);
    }

    @Override
    public ShopItem getShopItem(int id) {
        ShopItem curElement = null;
        for (ShopItem tmpElement : shopList) {
            if (tmpElement.getId() == id) {
                curElement = tmpElement;
                break;
            }
        }
        return curElement;
    }

    @Override
    public void editShopItem(ShopItem shopItem) {
        ShopItem tmpShopItem = getShopItem(shopItem.getId());
        deleteShopItem(tmpShopItem.getId());
        addShopItem(shopItem);
    }

    @Override
    public void deleteShopItem(int id) {
        ShopItem curShopItem = getShopItem(id);
        shopList.remove(curShopItem);
    }

    @Override
    public void addShopItem(ShopItem shopItem) {
        if (shopItem.getId() == ShopItem.UNDEFINED_ID) {
            shopItem.setId(this.autoIncrementId++);
        }
        shopList.add(shopItem);
    }
}
