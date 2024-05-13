package com.mercurx.tradingplatform.controller;

import com.mercurx.tradingplatform.model.Metrics;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {
    @PostMapping
    public Metrics saveMetrics(@RequestBody Metrics lcase) {
        return null;
    }
}
