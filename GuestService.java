package com.example.mygatedsociety.service;

import com.example.mygatedsociety.dto.GuestDto;
import com.example.mygatedsociety.enums.Status;
import com.example.mygatedsociety.model.Guest;

import java.util.List;

public interface GuestService {
    Status entry(GuestDto guest);
    GuestDto detail(long id);
    GuestDto edit(GuestDto guests, long id);
    void delete(long id);
}
