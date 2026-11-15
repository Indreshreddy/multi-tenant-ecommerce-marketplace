package com.example.marketplace.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="products",indexes=@Index(name="idx_product_tenant",columnList="tenant_id"))
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="tenant_id") private Tenant tenant;
 @ManyToOne(optional=false) @JoinColumn(name="vendor_id") private Vendor vendor;
 @Column(nullable=false,length=160) private String name;
 @Column(length=1000) private String description;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal price;
 @Column(nullable=false) private Integer stock;
 public Long getId(){return id;} public Tenant getTenant(){return tenant;} public void setTenant(Tenant v){tenant=v;}
 public Vendor getVendor(){return vendor;} public void setVendor(Vendor v){vendor=v;} public String getName(){return name;}
 public void setName(String v){name=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;} public Integer getStock(){return stock;} public void setStock(Integer v){stock=v;}
}