package com.example.restapihomework.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Buyer")
public class Buyer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long buyerId;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<Item> items;
}
