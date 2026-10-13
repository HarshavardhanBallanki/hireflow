package com.hireflow.controller;

import com.hireflow.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobService.findAll());
        return "jobs";
    }

    @GetMapping("/jobs/{id}")
    public String jobDetails(@PathVariable Long id, Model model) {
        model.addAttribute("job", jobService.findById(id));
        return "job-details";
    }
}
