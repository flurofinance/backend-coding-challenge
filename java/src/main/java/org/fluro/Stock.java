package org.fluro;

import java.util.Set;

public class Stock {
    private final Set<Item> items;

    public Stock(Set<Item> items) {
        this.items = items;
    }

    public int unitPrice(char sku) {
        return items.stream()
                .filter((item) -> item.sku() == sku).findFirst()
                .map((item) -> item.priceInPence()).orElseThrow(() -> new RuntimeException("sku $sku not found"));
    }
}
