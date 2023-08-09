package com.zoostore.storage.restexport;

import com.zoostore.storage.api.operations.createstorage.CreateStorageRequest;
import com.zoostore.storage.api.operations.createstorage.CreateStorageResponse;
import com.zoostore.storage.api.operations.edititemprice.EditStorageRequest;
import com.zoostore.storage.api.operations.edititemprice.EditStorageResponse;
import com.zoostore.storage.api.operations.exportitemquantity.ItemExportRequest;
import com.zoostore.storage.api.operations.exportitemquantity.ItemExportResponse;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsRequest;
import com.zoostore.storage.api.operations.getStorageItemsByIds.GetStorageItemsByIdsResponse;
import com.zoostore.storage.api.operations.getstorage.GetStorageRequest;
import com.zoostore.storage.api.operations.importitemquantity.ItemImportRequest;
import com.zoostore.storage.api.operations.importitemquantity.ItemImportResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Set;

@Headers({"Content-Type: application/json"})
public interface StorageRestExport {
    @RequestLine("POST/storages/storage")
    CreateStorageResponse createStorage(@Param CreateStorageRequest request);

    @RequestLine("PATCH/storages/storage")
    EditStorageResponse editStorage(@Param EditStorageRequest request);

    @RequestLine("PATCH/storages/export")
    ItemExportResponse itemExporting(@Param ItemExportRequest request);

    @RequestLine("PATCH/storages/import")
    ItemImportResponse itemImporting(@Param ItemImportRequest request);

    @RequestLine("GET/storages/storage/{id}")
    GetStorageRequest getStorage(@Param("id") String id);

    @RequestLine("GET/storages/{storageItems}")
    GetStorageItemsByIdsResponse getItemsByIds(@Param("storageItems") Set<String> storageItems);
}
