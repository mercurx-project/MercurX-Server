package com.mercurx.tradingplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
    @Table(name = "metrics")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Metrics {
        @Id
        private Long id;
        private String name;
        private String description;
        private Long assigneeId;
        private Date beginDate;
        private String priority;
}
