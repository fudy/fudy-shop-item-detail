package com.fudy.itemdetail.domain;

import lombok.Data;

@Data
public class ItemFeedbackLike {
    private Long itemId;
    private Long itemFeedbackId;
    private Long userId;

    public ItemFeedbackLike(Long itemId, Long itemFeedbackId, Long userId) {
        this.itemId = itemId;
        this.itemFeedbackId = itemFeedbackId;
        this.userId = userId;
    }
}
