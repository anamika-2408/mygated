package com.example.mygatedsociety.service;

import com.example.mygatedsociety.dto.GuestDto;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminService {
    List<GuestDto> fetchAllGuests();
    List<GuestDto> fetchAllGuestsInDuration(LocalDateTime start, LocalDateTime end);
}
