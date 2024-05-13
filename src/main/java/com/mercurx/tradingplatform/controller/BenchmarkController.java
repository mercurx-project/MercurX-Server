package com.mercurx.tradingplatform.controller;

import com.mercurx.tradingplatform.model.Benchmark;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/benchmark")
public class BenchmarkController {

    @GetMapping("/{id}")
    public Benchmark getBenchmarkReportById(@PathVariable Long id) {
        return null;
    }
}
