package com.fudy.itemdetail.interfaces.web.manager;

import com.fudy.itemdetail.interfaces.web.query.ItemFeedbackQuery;
import com.fudy.itemdetail.interfaces.web.vo.ItemFeedbackVO;

import javax.validation.Valid;
import java.util.List;

public interface ItemFeedbackManagerInterface {
    List<ItemFeedbackVO> getItemFeedbackList(ItemFeedbackQuery query);
    int getItemFeedbackTotal(@Valid ItemFeedbackQuery query);
}
