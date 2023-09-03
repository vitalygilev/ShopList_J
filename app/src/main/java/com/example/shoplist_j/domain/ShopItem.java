package com.example.shoplist_j.domain;

import androidx.annotation.Nullable;

public class ShopItem {

    public static int UNDEFINED_ID = -1;

    @Override
    public boolean equals(@Nullable Object obj) {
        ShopItem otherItem = (ShopItem)obj;
        return this.id == otherItem.id &&
                this.text == otherItem.text &&
                this.count == otherItem.count &&
                this.enabled == otherItem.enabled;
    }

    private int id;
    private String text;
    private int count;
    private boolean enabled;

    public ShopItem() {
    }

    public ShopItem(ShopItem shopItem) {
        this.id = shopItem.id;
        this.text = shopItem.text;
        this.count = shopItem.count;
        this.enabled = shopItem.enabled;
    }

    public ShopItem(int id, String text, int count, boolean enabled) {
        this.id = id;
        this.text = text;
        this.count = count;
        this.enabled = enabled;
    }

    public ShopItem(String text, int count, boolean enabled) {
        this.id = UNDEFINED_ID;
        this.text = text;
        this.count = count;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", count=" + count +
                ", enabled=" + enabled +
                '}';
    }
}
