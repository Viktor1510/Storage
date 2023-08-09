package com.zoostore.storage.api.operations.getallitems;

import com.zoostore.storage.api.base.OperationResult;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAllItemsResponse implements OperationResult {
    private List<GetAllItemSingleItem> items;
}
