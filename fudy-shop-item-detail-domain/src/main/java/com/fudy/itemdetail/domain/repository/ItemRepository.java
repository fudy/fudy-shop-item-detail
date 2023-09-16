package com.fudy.itemdetail.domain.repository;

import com.fudy.itemdetail.domain.Item;

public interface ItemRepository {
    Item getItem(Long itemId) throws Exception;
}
