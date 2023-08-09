package com.zoostore.storage.api.operations.importitemquantity;

import com.zoostore.storage.api.base.OperationRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemImportRequest implements OperationRequest {
    private String id;
    private String itemId;
    private Integer quantity;
}
