package com.fudy.itemdetail.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemPrice {
    private BigDecimal price;

    public ItemPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean greatThan(BigDecimal price) {
        if (null == price || null == this.price) {
            return false;
        }
        return price.compareTo(price) > 0;
    }

    public boolean lessThan(BigDecimal price) {
        if (null == price || null == this.price) {
            return false;
        }
        return price.compareTo(price) < 0;
    }
}
