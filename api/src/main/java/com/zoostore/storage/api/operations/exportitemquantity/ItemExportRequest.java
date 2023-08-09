package com.zoostore.storage.api.operations.exportitemquantity;

import com.zoostore.storage.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemExportRequest implements OperationRequest {
    private String id;
    private String itemId;
    private Integer quantity;
}
