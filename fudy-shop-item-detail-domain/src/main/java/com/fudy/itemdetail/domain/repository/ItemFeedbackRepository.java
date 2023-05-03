package com.fudy.itemdetail.domain.repository;

import com.fudy.itemdetail.domain.ItemFeedback;

import java.util.List;

public interface ItemFeedbackRepository {
    List<ItemFeedback> getItemFeedbackList(Long itemId, int offset, int pageSize);

    int getItemFeedbackCount(Long itemId);
}
