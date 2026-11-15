package com.example.marketplace.controller;
import com.example.marketplace.model.Tenant;
import com.example.marketplace.repository.TenantRepository;
import com.example.marketplace.service.TenantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/tenants")
public class TenantController {
 private final TenantService service; private final TenantRepository repo;
 public TenantController(TenantService s,TenantRepository r){service=s;repo=r;}
 public record TenantRequest(@NotBlank String name,@NotBlank String slug){}
 @PostMapping public Tenant create(@Valid @RequestBody TenantRequest r){return service.create(r.name(),r.slug());}
 @GetMapping public List<Tenant> list(){return repo.findAll();}
}