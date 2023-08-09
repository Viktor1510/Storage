package com.zoostore.storage.api.operations.getStorageItemsByIds;

import com.zoostore.storage.api.base.OperationResult;
import com.zoostore.storage.api.operations.getallitems.GetAllItemSingleItem;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetStorageItemsByIdsResponse implements OperationResult {
    private List<GetStorageItemsByIdsSingleItem> itemIds;
}
