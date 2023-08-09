package com.zoostore.storage.api.operations.getallitems;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllItemSingleItem{
    private String itemId;
    private BigDecimal price;
    private Integer quantity;
}
