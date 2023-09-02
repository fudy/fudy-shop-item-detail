package com.fudy.itemdetail.domain.repository;

import com.fudy.itemdetail.domain.ItemFeedbackLike;

public interface ItemFeedbackLikeRepository {
    void create(ItemFeedbackLike feedbackLike);

    void remove(ItemFeedbackLike feedbackLike);

    boolean exist(ItemFeedbackLike feedbackLike);
}
