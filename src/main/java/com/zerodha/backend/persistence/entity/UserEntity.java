package com.zerodha.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "emailAddress")
    String emailAddress;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<BankEntity> userBanks;

    @OneToMany(mappedBy = "investmentHolder", cascade = CascadeType.ALL)
    List<InvestmentEntity> investmentEntities;
}
