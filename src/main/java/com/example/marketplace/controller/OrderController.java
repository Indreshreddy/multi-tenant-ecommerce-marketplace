package com.example.marketplace.controller;
import com.example.marketplace.model.CustomerOrder;
import com.example.marketplace.repository.OrderRepository;
import com.example.marketplace.service.TenantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequestMapping("/api/orders")
public class OrderController {
 private final OrderRepository repo;private final TenantService tenants;
 public OrderController(OrderRepository r,TenantService t){repo=r;tenants=t;}
 public record OrderRequest(@NotBlank String customerName,@NotBlank @Email String customerEmail,
  @NotNull @DecimalMin("0.01") BigDecimal totalAmount){}
 @PostMapping public CustomerOrder create(@RequestHeader("X-Tenant-Id") Long tenantId,@Valid @RequestBody OrderRequest b){
  CustomerOrder o=new CustomerOrder();o.setTenant(tenants.require(tenantId));o.setCustomerName(b.customerName());o.setCustomerEmail(b.customerEmail());o.setTotalAmount(b.totalAmount());return repo.save(o);
 }
 @GetMapping public List<CustomerOrder> list(@RequestHeader("X-Tenant-Id") Long tenantId){tenants.require(tenantId);return repo.findAllByTenantId(tenantId);}
}