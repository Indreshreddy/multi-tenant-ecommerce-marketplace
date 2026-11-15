package com.example.marketplace.repository;
import com.example.marketplace.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<CustomerOrder,Long>{ List<CustomerOrder> findAllByTenantId(Long tenantId); }