package com.zoostore.storage.core.processors;

import com.zoostore.storage.api.operations.createstorage.CreateStorageOperation;
import com.zoostore.storage.api.operations.createstorage.CreateStorageRequest;
import com.zoostore.storage.api.operations.createstorage.CreateStorageResponse;
import com.zoostore.storage.persistence.entity.Storage;
import com.zoostore.storage.persistence.repositories.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateStorageProcessor implements CreateStorageOperation {
    private final StorageRepository storageRepository;
    @Override
    public CreateStorageResponse process(CreateStorageRequest request) {
        Storage storage=Storage.builder()
                .item(UUID.fromString(request.getItemId()))
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .build();

        storageRepository.save(storage);
        return CreateStorageResponse.builder()
                .id(storage.getId().toString())
                .itemId(storage.getItem().toString())
                .price(storage.getPrice())
                .quantity(storage.getQuantity())
                .build();
    }
}
