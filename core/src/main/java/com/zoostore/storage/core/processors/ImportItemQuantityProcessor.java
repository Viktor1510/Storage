package com.zoostore.storage.core.processors;

import com.zoostore.storage.api.operations.importitemquantity.ItemImportRequest;
import com.zoostore.storage.api.operations.importitemquantity.ItemImportResponse;
import com.zoostore.storage.api.operations.importitemquantity.ItemImportOperation;
import com.zoostore.storage.persistence.repositories.StorageRepository;
import com.zoostore.storage.persistence.entity.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImportItemQuantityProcessor implements ItemImportOperation {
    private final StorageRepository storageRepository;
    @Override
    public ItemImportResponse process(ItemImportRequest request) {
        Optional<Storage> storageOptional=storageRepository.findById(UUID.fromString(request.getId()));
        if(storageOptional.isEmpty()) {
            throw new RuntimeException();
        }

       Storage storage=storageOptional.get();
        storage.setQuantity(storage.getQuantity()+request.getQuantity());
        return ItemImportResponse.builder()
                .id(storage.getId().toString())
                .itemId(storage.getItem().toString())
                .price(storage.getPrice())
                .quantity(storage.getQuantity())
                .build();
    }
}
