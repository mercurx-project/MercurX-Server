package com.mercurx.tradingplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String username;
    private String name;
    private String password;
    private String role;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
