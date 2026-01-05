package com.gabrielmartins.expenses.service;

import com.gabrielmartins.expenses.entity.Transactions;
import com.gabrielmartins.expenses.entity.User;
import com.gabrielmartins.expenses.repository.transactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class transactionsService {

    @Autowired
    private transactionsRepository transactionsRepository;

    // Criação de uma nova transação
    public Transactions save(Transactions transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        return transactionsRepository.save(transactions);
    }

    // Buscar todas as transações
    public List<Transactions> findAll() {
        return transactionsRepository.findAll();
    }

    // Buscar transação por ID
    public Optional<Transactions> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return transactionsRepository.findById(id);
    }

    // Buscar transação por usuário
    public Transactions findByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return transactionsRepository.findByUser(user);
    }

    // Buscar transação por ID e usuário
    public Transactions findByIdAndUser(Long id, User user) {
        if (id == null || user == null) {
            throw new IllegalArgumentException("ID and User cannot be null");
        }
        return transactionsRepository.findByIdAndUser(id, user);
    }

    // Buscar transação por descrição
    public Transactions findByDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        return transactionsRepository.findByDescription(description);
    }

    // Buscar transação por valor
    public Transactions findByValue(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        return transactionsRepository.findByValue(value);
    }

    // Buscar transação por data
    public Transactions findByDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        return transactionsRepository.findByDate(date);
    }

    // Buscar transação por categoria
    public Transactions findByCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return transactionsRepository.findByCategory(category);
    }

    // Atualizar transação
    public Transactions update(Long id, Transactions updatedTransaction) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (updatedTransaction == null) {
            throw new IllegalArgumentException("Updated transaction cannot be null");
        }

        Optional<Transactions> existingTransaction = transactionsRepository.findById(id);
        if (existingTransaction.isPresent()) {
            Transactions transaction = existingTransaction.get();
            transaction.setDescription(updatedTransaction.getDescription());
            transaction.setValue(updatedTransaction.getValue());
            transaction.setType(updatedTransaction.getType());
            transaction.setCategory(updatedTransaction.getCategory());
            transaction.setDate(updatedTransaction.getDate());
            transaction.setUserId(updatedTransaction.getUserId());
            return transactionsRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found with id: " + id);
        }
    }

    // Deletar transação por ID
    public boolean deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (transactionsRepository.existsById(id)) {
            transactionsRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Transaction not found with id: " + id);
        }
    }

    // Verificar se transação existe
    public boolean existsById(Long id) {
        if (id == null) {
            return false;
        }
        return transactionsRepository.existsById(id);
    }

    // Contar total de transações
    public long count() {
        return transactionsRepository.count();
    }

}
