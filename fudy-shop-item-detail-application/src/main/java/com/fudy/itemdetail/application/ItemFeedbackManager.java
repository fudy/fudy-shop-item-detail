package com.fudy.itemdetail.application;

import com.fudy.itemdetail.application.assembler.ItemFeedbackAssembler;
import com.fudy.itemdetail.application.query.ItemFeedbackQuery;
import com.fudy.itemdetail.application.repository.ItemFeedbackRepository;
import com.fudy.itemdetail.application.vo.ItemFeedbackVO;
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
    private ItemFeedbackRepository repository;
    @Autowired
    private ItemFeedbackAssembler assembler;

    public List<ItemFeedbackVO> getItemFeedbackList(@Valid ItemFeedbackQuery query) {
        List<ItemFeedback> list = repository.getItemFeedbackList(query.getItemId());
        return assembler.toItemFeedbackVOList(list);
    }
}
