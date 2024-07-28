package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserDAO extends JpaRepository<UserEntity, Integer>, QuerydslPredicateExecutor<UserEntity>
{
}
