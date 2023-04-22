package com.fudy.itemdetail.infrastructure.mybatis.repository;

import com.fudy.itemdetail.domain.ItemFeedback;
import com.fudy.itemdetail.domain.repository.ItemFeedbackRepository;
import com.fudy.itemdetail.infrastructure.mybatis.convertor.ItemFeedbackConvertor;
import com.fudy.itemdetail.infrastructure.mybatis.data.ItemFeedbackDO;
import com.fudy.itemdetail.infrastructure.mybatis.mapper.ItemFeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemFeedbackRepositoryImpl implements ItemFeedbackRepository {
    @Autowired
    private ItemFeedbackMapper mapper;
    @Autowired
    private ItemFeedbackConvertor convertor;

    public List<ItemFeedback> getItemFeedbackList(Long itemId) {
        List<ItemFeedbackDO> list = mapper.selectList(itemId);
        return convertor.toItemFeedbackList(list);
    }
}
