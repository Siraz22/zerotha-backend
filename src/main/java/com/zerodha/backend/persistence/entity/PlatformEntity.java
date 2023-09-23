package com.zerodha.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "platform")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlatformEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @OneToOne(mappedBy = "platform", cascade = CascadeType.ALL)
    InvestmentEntity investment;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL)
    List<PlatformHasTransactionsEntity> platformHasTransactionsEntities;

}
