package com.hireflow.controller;

import com.hireflow.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.hireflow.model.Job;

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

    @GetMapping("/jobs/new")
    public String newJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "job-form";
    }

    @PostMapping("/jobs")
    public String saveJob(@ModelAttribute Job job) {
        jobService.save(job);
        return "redirect:/jobs";
    }

    @GetMapping("/jobs/{id}")
    public String jobDetails(@PathVariable Long id, Model model) {
        model.addAttribute("job", jobService.findById(id));
        return "job-details";
    }

    @GetMapping("/jobs/{id}/edit")
    public String editJobForm(@PathVariable Long id, Model model) {
        return "job-form";
    }

    @PostMapping("/jobs/{id}/delete")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteById(id);
        return "redirect:/jobs";
    }
}
