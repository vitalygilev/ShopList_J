package com.example.shoplist_j.domain;

public class DeleteShopItemUseCase {

    private ShopListRepository shopListRepository;

    public DeleteShopItemUseCase(ShopListRepository shopListRepository) {
        this.shopListRepository = shopListRepository;
    }

    public void deleteShopItem(int id) {
        shopListRepository.deleteShopItem(id);
    }

}
