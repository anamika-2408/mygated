package com.example.mygatedsociety.controller;

import com.example.mygatedsociety.dto.GuestDto;
import com.example.mygatedsociety.enums.Status;
import com.example.mygatedsociety.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping(path = "/Guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping(path = "/entry")
    public @ResponseBody Status entry(@RequestBody GuestDto guests) {
        return guestService.entry(guests);
    }

    @GetMapping(path = "/detail/" + "{id}")
    public @ResponseBody GuestDto guestDetail(@PathVariable("id") long id) {
        return guestService.detail(id);
    }

    @PutMapping(path = "/edit/" + "{id}")
    public @ResponseBody GuestDto editGuestDetail(
            @RequestBody GuestDto guests,
            @PathVariable("id") long id
    ) {
        return guestService.edit(guests, id);
    }

    @DeleteMapping(path = "/delete/" + "{id}")
    public @ResponseBody void deleteGuestDetail(@PathVariable("id") long id) {
        guestService.delete(id);
    }



}
