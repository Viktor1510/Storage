package com.zoostore.storage.api.operations.getstorage;

import com.zoostore.storage.api.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStorageResponse implements OperationResult {
    private String id;
    private String itemId;
    private BigDecimal price;
    private Integer quantity;
}
