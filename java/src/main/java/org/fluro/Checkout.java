package org.fluro;

import java.util.ArrayList;
import java.util.List;

class Checkout {
    private final List<Character> basket = new ArrayList<>();
    private final Stock stock;

    public Checkout(Stock stock) {
        this.stock = stock;
    }

    public int total() {
        return basket.stream().mapToInt((sku) -> stock.unitPrice(sku)).sum();
    }

    public Checkout scanItem(char sku) {
        basket.add(sku);
        return this;
    }
}
