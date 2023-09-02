package com.fudy.itemdetail.infrastructure.mybatis.repository;

import com.fudy.itemdetail.domain.ItemFeedbackLike;
import com.fudy.itemdetail.domain.repository.ItemFeedbackLikeRepository;
import com.fudy.itemdetail.infrastructure.mybatis.convertor.ItemFeedbackLikeConvertor;
import com.fudy.itemdetail.infrastructure.mybatis.data.ItemFeedbackLikeDO;
import com.fudy.itemdetail.infrastructure.mybatis.mapper.ItemFeedbackLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemFeedbackLikeRepositoryImpl implements ItemFeedbackLikeRepository {
    @Autowired
    private ItemFeedbackLikeMapper mapper;
    @Autowired
    private ItemFeedbackLikeConvertor convertor;
    @Override
    public void create(ItemFeedbackLike feedbackLike) {
        ItemFeedbackLikeDO likeDO = convertor.toItemFeedbackLikeDO(feedbackLike);
        mapper.insert(likeDO);
    }

    @Override
    public void remove(ItemFeedbackLike feedbackLike) {
        mapper.delete(feedbackLike.getItemFeedbackId(), feedbackLike.getUserId());
    }

    @Override
    public boolean exist(ItemFeedbackLike feedbackLike) {
        int count = mapper.count(feedbackLike.getItemFeedbackId(), feedbackLike.getUserId());
        return count>0;
    }
}
