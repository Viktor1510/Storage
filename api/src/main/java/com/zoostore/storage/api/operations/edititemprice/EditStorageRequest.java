package com.zoostore.storage.api.operations.edititemprice;

import com.zoostore.storage.api.base.OperationRequest;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditStorageRequest implements OperationRequest {
    private String id;
    private BigDecimal price;
}
