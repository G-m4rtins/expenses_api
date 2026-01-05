package com.gabrielmartins.expenses.repository;

import com.gabrielmartins.expenses.entity.Transactions;
import com.gabrielmartins.expenses.entity.User;

import java.util.List;

public interface transactionsRepository extends org.springframework.data.jpa.repository.JpaRepository<com.gabrielmartins.expenses.entity.Transactions, Long> {

    List<Transactions> findAll();
    Transactions findByUser(User user);
    Transactions findByIdAndUser(Long id, User user);
    Transactions findByDescription(String description);
    Transactions findByValue(Double value);
    Transactions findByDate(String date);
    Transactions findByCategory(String category);

}
