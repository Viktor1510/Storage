package com.zoostore.storage.api.operations.getStorageItemsByIds;

import com.zoostore.storage.api.base.OperationRequest;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStorageItemsByIdsRequest implements OperationRequest {
    private Set<String> itemIds;
}
