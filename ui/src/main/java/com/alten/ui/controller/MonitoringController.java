package com.alten.ui.controller;

import com.alten.ui.dto.FilterDTO;
import com.alten.ui.service.MonitoringService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("monitoring")
@AllArgsConstructor
public class MonitoringController {

    private final MonitoringService monitoringService;

    @GetMapping
    public String monitor(@ModelAttribute("filter") FilterDTO filter, Model model) {
        model.addAttribute("customerVehicles", monitoringService.getCustomerVehicles());
        return "monitoring";
    }

    @PostMapping("filter")
    public String filter(@ModelAttribute("filter") FilterDTO filter, Model model) {
        model.addAttribute("customerVehicles", monitoringService.getCustomerVehiclesByFilter(filter));
        return "monitoring";
    }
}
