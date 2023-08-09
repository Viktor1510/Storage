package com.zoostore.storage.api.operations.createstorage;

import com.zoostore.storage.api.base.OperationRequest;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStorageRequest implements OperationRequest {
    private String itemId;
    private BigDecimal price;
    private Integer quantity;
}
