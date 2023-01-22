package com.example.mygatedsociety.controller;


import com.example.mygatedsociety.dto.GuestDto;
import com.example.mygatedsociety.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/fetch-guests")
    public @ResponseBody List<GuestDto> fetchAllGuests() {
        return adminService.fetchAllGuests();
    }

    @GetMapping(path = "/duration")
    public @ResponseBody List<GuestDto> fetchAllGuestsInDuration(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam(value = "start") LocalDateTime start,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam(value = "end") LocalDateTime end
    ) {
        return adminService.fetchAllGuestsInDuration(start, end);
    }
}
