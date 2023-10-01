package com.fudy.itemdetail.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Item {
    private Long id;
    private String title;
    private String mainImage;
    private List<String> imageList;
    private int sales;
    private List<Map<String, List<Object>>> attributeList;
    private List<ItemSku> skuList;
    private ItemPrice minPrice;
    private ItemPrice maxPrice;
    private String desc;

    public static String getOptionKey(String attrKey, Object attrValue) {
        return attrKey + "-" + attrValue;
    }

    public List<String> getAttributeKeyList() {
        if (null == attributeList) {
            return null;
        }
        List<String> keyList = new ArrayList<>();
        for (Map<String, List<Object>> map : attributeList) {
            String key = map.keySet().stream().findFirst().get();
            keyList.add(key);
        }
        return keyList;
    }

    public String getMinPriceStr() {
        return null == minPrice ? null : minPrice.toString();
    }

    public String getMaxPriceStr() {
        return null == maxPrice ? null : maxPrice.toString();
    }

    public void calcMinAndMaxPrice() {
        if (null == skuList) {
            return;
        }
        for (ItemSku sku : skuList) {
            BigDecimal price = sku.getPrice();
            if (null == minPrice) {
                minPrice = new ItemPrice(price);
            }
            if (null == maxPrice) {
                maxPrice = new ItemPrice(price);
            }
            if (minPrice.greatThan(price)) {
                minPrice = new ItemPrice(price);
            }
            if (maxPrice.lessThan(price)) {
                maxPrice = new ItemPrice(price);
            }
        }
    }
}
