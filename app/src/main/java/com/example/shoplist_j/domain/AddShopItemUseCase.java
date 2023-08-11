package com.example.shoplist_j.domain;

public class AddShopItemUseCase {

    private ShopListRepository shopListRepository;

    public AddShopItemUseCase(ShopListRepository shopListRepository) {
        this.shopListRepository = shopListRepository;
    }

    public void addShopItem(ShopItem shopItem) {
        shopListRepository.addShopItem(shopItem);
    }

}
