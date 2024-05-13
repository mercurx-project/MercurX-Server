package com.mercurx.tradingplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "benchmark")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Benchmark {
        @Id
        private Long id;
        private String name;
        private Long caseId;
        private String description;
        private Long ownerId;
        private String type;
    }