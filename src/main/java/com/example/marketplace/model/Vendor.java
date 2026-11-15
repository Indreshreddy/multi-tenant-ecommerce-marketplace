package com.example.marketplace.model;
import jakarta.persistence.*;
@Entity @Table(name="vendors",indexes=@Index(name="idx_vendor_tenant",columnList="tenant_id"))
public class Vendor {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="tenant_id") private Tenant tenant;
 @Column(nullable=false,length=120) private String name;
 @Column(nullable=false,length=160) private String email;
 @Column(length=30) private String phone;
 @Column(nullable=false) private boolean active=true;
 public Long getId(){return id;} public Tenant getTenant(){return tenant;} public void setTenant(Tenant v){tenant=v;}
 public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;}
 public void setEmail(String v){email=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}