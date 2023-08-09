package com.zoostore.storage.core.processors;

import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsOperation;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsRequest;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsResponse;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsSingleItem;
import com.zoostore.storage.core.exceptions.InvalidUuidException;
import com.zoostore.storage.persistence.entity.Storage;
import com.zoostore.storage.persistence.repositories.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class GetStorageItemsByIdsProcessor implements GetStorageItemsByIdsOperation {
   private final StorageRepository storageRepository;
    @Override
    public GetStorageItemsByIdsResponse process(GetStorageItemsByIdsRequest input) {
        List<String> itemIds=List.of(input.getItemIds().toArray(String[]::new));

        if(itemIds.isEmpty())
        {
            throw new InvalidUuidException();
        }

        Set<Storage> items=this.storageRepository.findByIdIn(itemIds.stream().map(UUID::fromString).toList());

        return GetStorageItemsByIdsResponse.builder().itemIds(
                        items.stream()
                                .map(this::mapToSingleItem)
                                .toList())
                .build();
    }

    private GetStorageItemsByIdsSingleItem mapToSingleItem(Storage storage){
        return  GetStorageItemsByIdsSingleItem
                .builder()
                .id(storage.getId().toString())
                .itemId(storage.getItem().toString())
                .price(storage.getPrice())
                .quantity(storage.getQuantity())
                .build();
    }

}
