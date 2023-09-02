package com.fudy.itemdetail.interfaces.web;

import com.fudy.itemdetail.interfaces.web.manager.ItemFeedbackManagerInterface;
import com.fudy.itemdetail.interfaces.web.query.ItemFeedbackQuery;
import com.fudy.itemdetail.interfaces.web.vo.ItemFeedbackVO;
import com.fudy.shop.common.PagingResult;
import com.fudy.shop.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
public class ItemFeedbackController {
    @Autowired
    private ItemFeedbackManagerInterface manager;

    @CrossOrigin
    @GetMapping("/api/item-feedbacks")
    public @ResponseBody
    PagingResult<List<ItemFeedbackVO>> getItemFeedbackList(ItemFeedbackQuery query) {
        try {
            List<ItemFeedbackVO> data = manager.getItemFeedbackList(query);
            int total = manager.getItemFeedbackTotal(query);
            return PagingResult.success(data,total);
        } catch (Exception e) {
            log.error(e.getMessage());
            return PagingResult.fail(null, e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping("/api/item-feedbacks/{id}")
    public @ResponseBody
    Result<Integer> likeItemFeedback(@PathVariable("id") Long id, @RequestParam("itemId") Long itemId) {
        try {
            Long userId = 10000001L; //暂时mock下，后续介绍到单点登录到时候会继续说明
            Objects.requireNonNull(itemId, "itemId is null");
            Integer data = manager.likeItemFeedback(id, userId, itemId);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(null, e.getMessage());
        }
    }
}
