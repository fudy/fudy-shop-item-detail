package com.fudy.itemdetail.interfaces.web;

import com.fudy.itemdetail.interfaces.web.manager.ItemFeedbackManagerInterface;
import com.fudy.itemdetail.interfaces.web.query.ItemFeedbackQuery;
import com.fudy.itemdetail.interfaces.web.vo.ItemFeedbackVO;
import com.fudy.shop.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class ItemFeedbackController {
    @Autowired
    private ItemFeedbackManagerInterface manager;

    @CrossOrigin
    @GetMapping("/api/item-feedbacks")
    public @ResponseBody
    Result<List<ItemFeedbackVO>> getItemFeedbackList(@RequestBody ItemFeedbackQuery query) {
        try {
            List<ItemFeedbackVO> data = manager.getItemFeedbackList(query);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(null, e.getMessage());
        }
    }
}
