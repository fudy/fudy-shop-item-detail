package com.fudy.itemdetail.application.dto;

import com.fudy.shop.common.PagingQuery;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemFeedbackQuery extends PagingQuery {
    private static final long serialVersionUID = 3443294100413385149L;
    @NotNull(message = "itemId should not be null")
    private Long itemId;
}
