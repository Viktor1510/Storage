package com.zoostore.storage.core.processors;


import com.zoostore.storage.api.operations.getstorage.GetStorageItemOperation;
import com.zoostore.storage.api.operations.getstorage.GetStorageRequest;
import com.zoostore.storage.api.operations.getstorage.GetStorageResponse;
import com.zoostore.storage.persistence.repositories.StorageRepository;
import com.zoostore.storage.persistence.entity.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetStorageProcessor implements GetStorageItemOperation {
    private final StorageRepository storageRepository;
    @Override
    public GetStorageResponse process(GetStorageRequest request) {
        Optional<Storage> storageOptional=storageRepository.findById(request.getId());
        return storageOptional.map(storage -> GetStorageResponse.builder()
                .id(storage.getId().toString())
                .itemId(storage.getItem().toString())
                .price(storage.getPrice())
                .quantity(storage.getQuantity())
                .build()).orElseThrow();
    }
}
