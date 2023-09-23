package com.zerodha.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bank")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "ref_user")
    UserEntity user;

    @OneToMany(mappedBy = "bankEntity", cascade = CascadeType.ALL)
    List<PlatformHasTransactionsEntity> bankUsedInPlatformTransactions;
}