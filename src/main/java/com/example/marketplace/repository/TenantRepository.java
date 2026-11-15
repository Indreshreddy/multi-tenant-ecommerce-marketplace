package com.example.marketplace.repository;
import com.example.marketplace.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TenantRepository extends JpaRepository<Tenant,Long>{ boolean existsBySlug(String slug); }