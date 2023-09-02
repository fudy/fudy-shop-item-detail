package com.fudy.itemdetail.application;

import com.fudy.itemdetail.application.assembler.ItemFeedbackAssembler;
import com.fudy.itemdetail.domain.ItemFeedbackLike;
import com.fudy.itemdetail.domain.repository.ItemFeedbackLikeRepository;
import com.fudy.itemdetail.domain.repository.ItemFeedbackRepository;
import com.fudy.itemdetail.interfaces.web.manager.ItemFeedbackManagerInterface;
import com.fudy.itemdetail.interfaces.web.query.ItemFeedbackQuery;
import com.fudy.itemdetail.domain.ItemFeedback;
import com.fudy.itemdetail.interfaces.web.vo.ItemFeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class ItemFeedbackManager implements ItemFeedbackManagerInterface {
    @Autowired
    private ItemFeedbackRepository repository;
    @Autowired
    private ItemFeedbackAssembler assembler;
    @Autowired
    private ItemFeedbackLikeRepository likeRepository;

    public List<ItemFeedbackVO> getItemFeedbackList(@Valid ItemFeedbackQuery query) {
        List<ItemFeedback> list = repository.getItemFeedbackList(query.getItemId(), query.offset(), query.getPageSize());
        return assembler.toItemFeedbackVOList(list);
    }

    public int getItemFeedbackTotal(@Valid ItemFeedbackQuery query) {
        return repository.getItemFeedbackCount(query.getItemId());
    }

    @Override
    public int likeItemFeedback(Long itemFeedbackId, Long userId, Long itemId) {
        ItemFeedbackLike itemFeedbackLike = new ItemFeedbackLike(itemId, itemFeedbackId, userId);
        //todo给feedbackId加锁
        if (likeRepository.exist(itemFeedbackLike)) {
            likeRepository.remove(itemFeedbackLike);
            repository.decreaseLikeNum();
            return -1;
        } else {
            likeRepository.create(itemFeedbackLike);
            repository.increaseLikeNum();
            return 1;
        }
    }
}
