package com.example.shoplist_j.domain;

import java.util.List;

public class GetShopListUseCase  {

    public GetShopListUseCase(ShopListRepository shopListRepository) {
        this.shopListRepository = shopListRepository;
    }

    private ShopListRepository shopListRepository;

    public List<ShopItem> getShopList() {
        return shopListRepository.getShopList();
    }

}
