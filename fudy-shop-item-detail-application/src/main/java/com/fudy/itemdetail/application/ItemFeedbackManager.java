package com.fudy.itemdetail.application;

import com.fudy.itemdetail.application.assembler.ItemFeedbackAssembler;
import com.fudy.itemdetail.application.dto.ItemFeedbackQuery;
import com.fudy.itemdetail.application.dto.ItemFeedbackDTO;
import com.fudy.itemdetail.domain.ItemService;
import com.fudy.itemdetail.domain.repository.ItemFeedbackLikeRepository;
import com.fudy.itemdetail.domain.repository.ItemFeedbackRepository;
import com.fudy.itemdetail.domain.ItemFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class ItemFeedbackManager {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemFeedbackRepository repository;
    @Autowired
    private ItemFeedbackAssembler assembler;
    @Autowired
    private ItemFeedbackLikeRepository likeRepository;

    public List<ItemFeedbackDTO> getItemFeedbackList(@Valid ItemFeedbackQuery query) {
        List<ItemFeedback> list = itemService.getItemFeedbackList(query.getItemId(), query.offset(), query.getPageSize());
        return assembler.toItemFeedbackDTOList(list);
    }

    public int getItemFeedbackTotal(@Valid ItemFeedbackQuery query) {
        return itemService.getItemFeedbackCount(query.getItemId());
    }

    public int likeItemFeedback(Long itemFeedbackId, Long userId, Long itemId) {
        return itemService.likeItemFeedback(itemFeedbackId, userId, itemId);
    }
}
