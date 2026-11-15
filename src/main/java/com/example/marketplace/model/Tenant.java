package com.example.marketplace.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name="tenants")
public class Tenant {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=100) private String name;
 @Column(nullable=false,unique=true,length=120) private String slug;
 @Column(nullable=false) private Instant createdAt=Instant.now();
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getSlug(){return slug;} public void setSlug(String v){slug=v;} public Instant getCreatedAt(){return createdAt;}
}