package com.zoostore.storage.persistence.repositories;

import com.zoostore.storage.persistence.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<Storage, UUID> {
}
