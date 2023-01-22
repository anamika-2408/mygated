package com.example.mygatedsociety.service.impl;

import com.example.mygatedsociety.dto.GuestDto;
import com.example.mygatedsociety.mapper.GuestMapper;
import com.example.mygatedsociety.repository.GuestRepository;
import com.example.mygatedsociety.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestMapper guestMapper;

    @Override
    public List<GuestDto> fetchAllGuests() {
        return guestMapper.convertListToDto(guestRepository.findAll());
    }

    @Override
    public List<GuestDto> fetchAllGuestsInDuration(LocalDateTime start, LocalDateTime end) {
        return guestMapper.convertListToDto(guestRepository.findByEntryTimeBetween(start, end));
    }
}
