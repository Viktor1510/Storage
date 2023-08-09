package com.zoostore.storage.api.operations.getstorage;

import com.zoostore.storage.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class GetStorageRequest implements OperationRequest {
    private UUID id;
}
