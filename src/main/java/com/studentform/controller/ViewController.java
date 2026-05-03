package com.studentform.controller;

import com.studentform.dto.ViewStatsDTO;
import com.studentform.service.ViewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/students/views")
@CrossOrigin(origins = "http://localhost:3001")
public class ViewController {

    private final ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    // ✅ GET view stats
    @GetMapping
    public List<ViewStatsDTO> getViewStats() {
        return viewService.getViewsBySource();
    }
}
