package com.zoostore.storage.api.operations.getallitems;

import com.zoostore.storage.api.base.OperationRequest;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllItemsRequest implements OperationRequest {
    private List<GetAllItemSingleItem> items;
}
