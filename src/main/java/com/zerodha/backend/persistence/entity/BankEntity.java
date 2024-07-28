package com.zerodha.backend.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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