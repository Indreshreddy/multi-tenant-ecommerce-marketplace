package com.example.marketplace.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
@Entity @Table(name="customer_orders",indexes=@Index(name="idx_order_tenant",columnList="tenant_id"))
public class CustomerOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="tenant_id") private Tenant tenant;
 @Column(nullable=false,length=120) private String customerName;
 @Column(nullable=false,length=160) private String customerEmail;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal totalAmount;
 @Column(nullable=false,length=20) private String status="PLACED";
 @Column(nullable=false) private Instant createdAt=Instant.now();
 public Long getId(){return id;} public Tenant getTenant(){return tenant;} public void setTenant(Tenant v){tenant=v;}
 public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
 public String getCustomerEmail(){return customerEmail;} public void setCustomerEmail(String v){customerEmail=v;}
 public BigDecimal getTotalAmount(){return totalAmount;} public void setTotalAmount(BigDecimal v){totalAmount=v;}
 public String getStatus(){return status;} public Instant getCreatedAt(){return createdAt;}
}