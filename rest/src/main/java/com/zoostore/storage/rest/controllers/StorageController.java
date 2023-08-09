package com.zoostore.storage.rest.controllers;


import com.zoostore.storage.api.operations.createstorage.CreateStorageOperation;
import com.zoostore.storage.api.operations.createstorage.CreateStorageRequest;
import com.zoostore.storage.api.operations.createstorage.CreateStorageResponse;
import com.zoostore.storage.api.operations.edititemprice.EditStorageOperation;
import com.zoostore.storage.api.operations.edititemprice.EditStorageRequest;
import com.zoostore.storage.api.operations.edititemprice.EditStorageResponse;
import com.zoostore.storage.api.operations.exportitemquantity.ItemExportOperation;
import com.zoostore.storage.api.operations.exportitemquantity.ItemExportRequest;
import com.zoostore.storage.api.operations.exportitemquantity.ItemExportResponse;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsOperation;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsRequest;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsResponse;
import com.zoostore.storage.api.operations.getstorage.GetStorageItemOperation;
import com.zoostore.storage.api.operations.getstorage.GetStorageRequest;
import com.zoostore.storage.api.operations.getstorage.GetStorageResponse;
import com.zoostore.storage.api.operations.importitemquantity.ItemImportOperation;
import com.zoostore.storage.api.operations.importitemquantity.ItemImportRequest;
import com.zoostore.storage.api.operations.importitemquantity.ItemImportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storages")
public class StorageController {
    private final CreateStorageOperation createStorageOperation;
    private final EditStorageOperation editStorageOperation;
    private final ItemExportOperation itemExportOperation;
    private final GetStorageItemOperation getStorageItemProcessor;
    private final ItemImportOperation itemImportOperation;

    private final GetStorageItemsByIdsOperation getStorageItemsByIdsOperation;

    @PostMapping(path ="/storage")
    public ResponseEntity<CreateStorageResponse> createStorage(@RequestBody CreateStorageRequest request){
        return ResponseEntity.ok(createStorageOperation.process(request));
    }
    @PatchMapping (path = "/storage")
    public ResponseEntity<EditStorageResponse> editStorage(@RequestBody EditStorageRequest request){
        return ResponseEntity.ok(editStorageOperation.process(request));
    }

    @PatchMapping(path="/export")
    public ResponseEntity<ItemExportResponse> itemExporting(@RequestBody ItemExportRequest request){
        return ResponseEntity.ok(itemExportOperation.process(request));
    }

    @GetMapping(path="/storage/{id}")
    public ResponseEntity<GetStorageResponse> getStorage(@PathVariable String id){
        return ResponseEntity.ok(getStorageItemProcessor.process(GetStorageRequest.builder().id(UUID.fromString(id)).build()));
    }

    @PatchMapping(path="/import")
    public ResponseEntity<ItemImportResponse> itemImporting(@RequestBody ItemImportRequest request){
        return ResponseEntity.ok(itemImportOperation.process(request));
    }
    @GetMapping(path="/{storageItems}")
    public ResponseEntity<GetStorageItemsByIdsResponse> getItemsByIds(@PathVariable Set<String> storageItems){
        return ResponseEntity.ok(getStorageItemsByIdsOperation.process(GetStorageItemsByIdsRequest.builder().itemIds(storageItems).build()));
    }
}
