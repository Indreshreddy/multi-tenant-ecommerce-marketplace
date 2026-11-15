package com.example.marketplace.controller;
import com.example.marketplace.model.*;
import com.example.marketplace.repository.VendorRepository;
import com.example.marketplace.service.TenantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/vendors")
public class VendorController {
 private final VendorRepository repo; private final TenantService tenants;
 public VendorController(VendorRepository r,TenantService t){repo=r;tenants=t;}
 public record VendorRequest(@NotBlank String name,@NotBlank @Email String email,String phone){}
 @PostMapping public Vendor create(@RequestHeader("X-Tenant-Id") Long tenantId,@Valid @RequestBody VendorRequest b){
  Vendor v=new Vendor();v.setTenant(tenants.require(tenantId));v.setName(b.name());v.setEmail(b.email());v.setPhone(b.phone());return repo.save(v);
 }
 @GetMapping public List<Vendor> list(@RequestHeader("X-Tenant-Id") Long tenantId){tenants.require(tenantId);return repo.findAllByTenantId(tenantId);}
 @GetMapping("/{id}") public Vendor get(@RequestHeader("X-Tenant-Id") Long tenantId,@PathVariable Long id){
  return repo.findByIdAndTenantId(id,tenantId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Vendor not found"));
 }
}