package com.zoostore.storage.core.processors;

import com.zoostore.storage.api.operations.edititemprice.EditStorageRequest;
import com.zoostore.storage.api.operations.edititemprice.EditStorageResponse;
import com.zoostore.storage.api.operations.edititemprice.EditStorageOperation;
import com.zoostore.storage.persistence.repositories.StorageRepository;
import com.zoostore.storage.persistence.entity.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemPriceProcessor implements EditStorageOperation {
    private final StorageRepository storageRepository;

    @Override
    public EditStorageResponse process(EditStorageRequest input) {
        Optional<Storage> storageOptional=storageRepository.findById(UUID.fromString(input.getId()));
        if(storageOptional.isPresent()){
            Storage storage=storageOptional.get();
            storage.setPrice(input.getPrice());
            return EditStorageResponse.builder()
                    .id(storage.getId().toString())
                    .itemId(storage.getItem().toString())
                    .price(storage.getPrice())
                    .quantity(storage.getQuantity())
                    .build();
        }
        throw new RuntimeException();
    }
}
