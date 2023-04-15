package com.fudy.itemdetail.application.query;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ItemFeedbackQuery implements Serializable {
    private static final long serialVersionUID = 3443294100413385149L;
    @NotNull(message = "itemId should not be null")
    private Long itemId;
}
