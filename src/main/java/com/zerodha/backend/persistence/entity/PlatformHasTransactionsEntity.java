package com.zerodha.backend.persistence.entity;

import com.zerodha.backend.enums.PlatformTransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "platform_has_transaction")
public class PlatformHasTransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "amount")
    BigDecimal amount;

    @Enumerated(value = EnumType.STRING)
    PlatformTransactionType platformTransactionType;

    @ManyToOne
    @JoinColumn(name = "ref_platform")
    PlatformEntity platform;

    @ManyToOne
    @JoinColumn(name = "ref_bank")
    BankEntity bankEntity;

}
