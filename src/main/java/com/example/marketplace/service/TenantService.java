package com.example.marketplace.service;
import com.example.marketplace.model.Tenant;
import com.example.marketplace.repository.TenantRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@Service
public class TenantService {
 private final TenantRepository repo;
 public TenantService(TenantRepository repo){this.repo=repo;}
 public Tenant create(String name,String slug){
  if(repo.existsBySlug(slug)) throw new ResponseStatusException(HttpStatus.CONFLICT,"Tenant slug already exists");
  Tenant t=new Tenant(); t.setName(name); t.setSlug(slug); return repo.save(t);
 }
 public Tenant require(Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Tenant not found"));}
}