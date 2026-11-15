package com.example.marketplace.repository;
import com.example.marketplace.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface VendorRepository extends JpaRepository<Vendor,Long>{
 List<Vendor> findAllByTenantId(Long tenantId);
 Optional<Vendor> findByIdAndTenantId(Long id,Long tenantId);
}