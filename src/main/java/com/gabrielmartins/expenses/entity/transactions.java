package com.gabrielmartins.expenses.entity;


import com.gabrielmartins.expenses.entity.enums.EnumsCategory;
import com.gabrielmartins.expenses.entity.enums.EnumsType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class transactions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal value;
    private EnumsType type;
    private EnumsCategory Category;
    private LocalDate date;

    private Long userId;

    public transactions(String description, BigDecimal value, EnumsType type, EnumsCategory category, LocalDate date, Long userId) {
        this.description = description;
        this.value = value;
        this.type = type;
        Category = category;
        this.date = date;
        this.userId = userId;
    }

    public transactions() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public EnumsType getType() {
        return type;
    }

    public void setType(EnumsType type) {
        this.type = type;
    }

    public EnumsCategory getCategory() {
        return Category;
    }

    public void setCategory(EnumsCategory category) {
        Category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
