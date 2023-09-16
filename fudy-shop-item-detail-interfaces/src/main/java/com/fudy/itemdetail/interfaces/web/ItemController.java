package com.fudy.itemdetail.interfaces.web;

import com.fudy.itemdetail.application.ItemManager;
import com.fudy.itemdetail.application.dto.ItemDTO;
import com.fudy.shop.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class ItemController {
    @Autowired
    private ItemManager itemManager;

    @CrossOrigin
    @GetMapping("/api/item/{id}")
    public @ResponseBody
    Result<ItemDTO> getItem(@PathVariable Long id) {
        try {
            ItemDTO data = itemManager.getItem(id);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(null, e.getMessage());
        }
    }

}
