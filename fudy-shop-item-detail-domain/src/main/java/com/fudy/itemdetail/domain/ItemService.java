package com.fudy.itemdetail.domain;

import com.fudy.itemdetail.domain.repository.ItemFeedbackLikeRepository;
import com.fudy.itemdetail.domain.repository.ItemFeedbackRepository;
import com.fudy.itemdetail.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository repository;
    private ItemFeedbackRepository feedbackRepository;
    private ItemFeedbackLikeRepository feedbackLikeRepository;

    @Autowired
    public ItemService(ItemRepository repository,
                       ItemFeedbackRepository feedbackRepository,
                       ItemFeedbackLikeRepository feedbackLikeRepository) {
        this.repository = repository;
        this.feedbackRepository = feedbackRepository;
        this.feedbackLikeRepository = feedbackLikeRepository;
    }

    public Item getItem(Long itemId) throws Exception {
        return repository.getItem(itemId);
    }

    public List<ItemFeedback> getItemFeedbackList(Long itemId, int offset, int pageSize) {
        return feedbackRepository.getItemFeedbackList(itemId, offset, pageSize);
    }

    public int getItemFeedbackCount(Long itemId) {
        return feedbackRepository.getItemFeedbackCount(itemId);
    }

    public int likeItemFeedback(Long itemFeedbackId, Long userId, Long itemId) {
        ItemFeedbackLike itemFeedbackLike = new ItemFeedbackLike(itemId, itemFeedbackId, userId);
        //todo给feedbackId加锁
        if (feedbackLikeRepository.exist(itemFeedbackLike)) {
            feedbackLikeRepository.remove(itemFeedbackLike);
            feedbackRepository.decreaseLikeNum();
            return -1;
        } else {
            feedbackLikeRepository.create(itemFeedbackLike);
            feedbackRepository.increaseLikeNum();
            return 1;
        }
    }

}
