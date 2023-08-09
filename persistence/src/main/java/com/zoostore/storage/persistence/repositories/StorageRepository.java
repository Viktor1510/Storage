package com.zoostore.storage.persistence.repositories;

import com.zoostore.storage.persistence.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface StorageRepository extends JpaRepository<Storage,UUID> {
    @Override
    Optional<Storage> findById(UUID Id);
    Set<Storage> findByIdIn(List<UUID> Id);

}
