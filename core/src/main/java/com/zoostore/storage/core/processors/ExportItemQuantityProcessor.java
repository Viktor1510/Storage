package com.zoostore.storage.core.processors;


import com.zoostore.storage.api.operations.exportitemquantity.ItemExportRequest;
import com.zoostore.storage.api.operations.exportitemquantity.ItemExportResponse;
import com.zoostore.storage.api.operations.exportitemquantity.ItemExportOperation;
import com.zoostore.storage.persistence.repositories.StorageRepository;
import com.zoostore.storage.persistence.entity.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExportItemQuantityProcessor implements ItemExportOperation {
    private final StorageRepository storageRepository;

    @Override
    public ItemExportResponse process(ItemExportRequest request) {
        Optional<Storage> storageOptional=storageRepository.findById(UUID.fromString(request.getId()));
        if(storageOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Storage storage=storageOptional.get();
        if(storage.getQuantity()< request.getQuantity()) {
            throw new RuntimeException();
        }

        storage.setQuantity(storage.getQuantity()-request.getQuantity());
        return ItemExportResponse.builder()
                .id(storage.getId().toString())
                .itemId(storage.getItem().toString())
                .price(storage.getPrice())
                .quantity(storage.getQuantity())
                .build();
    }
}

