package com.zoostore.storage.api.operations.getStorageItemsByIds;


import lombok.*;


import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStorageItemsByIdsSingleItem {
    private String id;
    private String itemId;
    private BigDecimal price;
    private Integer quantity;
}
