package com.example.marketplace.controller;
import com.example.marketplace.model.*;
import com.example.marketplace.repository.*;
import com.example.marketplace.service.TenantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequestMapping("/api/products")
public class ProductController {
 private final ProductRepository products; private final VendorRepository vendors; private final TenantService tenants;
 public ProductController(ProductRepository p,VendorRepository v,TenantService t){products=p;vendors=v;tenants=t;}
 public record ProductRequest(@NotNull Long vendorId,@NotBlank String name,String description,
  @NotNull @DecimalMin("0.01") BigDecimal price,@NotNull @Min(0) Integer stock){}
 @PostMapping public Product create(@RequestHeader("X-Tenant-Id") Long tenantId,@Valid @RequestBody ProductRequest b){
  Tenant tenant=tenants.require(tenantId);
  Vendor vendor=vendors.findByIdAndTenantId(b.vendorId(),tenantId).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Vendor does not belong to this tenant"));
  Product p=new Product();p.setTenant(tenant);p.setVendor(vendor);p.setName(b.name());p.setDescription(b.description());p.setPrice(b.price());p.setStock(b.stock());return products.save(p);
 }
 @GetMapping public List<Product> list(@RequestHeader("X-Tenant-Id") Long tenantId){tenants.require(tenantId);return products.findAllByTenantId(tenantId);}
}