package com.example.restapihomework.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Item")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderId;

  @ManyToOne
  @JoinColumn(name = "buyer_id")
  private Buyer buyerId;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "item_category")
  private String itemCategory;
}
