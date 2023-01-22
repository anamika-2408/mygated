package com.example.mygatedsociety.service.impl;

import com.example.mygatedsociety.dto.GuestDto;
import com.example.mygatedsociety.enums.Status;
import com.example.mygatedsociety.mapper.GuestMapper;
import com.example.mygatedsociety.model.Guest;
import com.example.mygatedsociety.repository.GuestRepository;
import com.example.mygatedsociety.service.GuestService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestMapper guestMapper;


    @Override
    public Status entry(GuestDto guests) {
        Guest guest = guestMapper.convertToEntity(guests);
        guest.setEntryTime(LocalDateTime.now());
        guest = guestRepository.save(guest);

        if(!guest.isAction()) {
            return Status.REJECTED;
        }
        return Status.APPROVED;
    }

    @Override
    public GuestDto detail(final long id) {
        return guestMapper.convertToDto(guestRepository.findById(id).get());
    }

    @Override
    public GuestDto edit(GuestDto guestTobeUpdated, long id) {
        Optional<Guest> savedGuestOptional = guestRepository.findById(id);
        if(savedGuestOptional.isPresent()) {
            Guest guest = savedGuestOptional.get();
            if(!StringUtils.isEmpty(guestTobeUpdated.getName())) {
                guest.setName(guestTobeUpdated.getName());
            }
            if(!StringUtils.isEmpty(guestTobeUpdated.getFlatNo())) {
                guest.setFlatNo(guestTobeUpdated.getFlatNo());
            }
            if(!StringUtils.isEmpty(guestTobeUpdated.getPhone())) {
                guest.setPhone(guestTobeUpdated.getPhone());
            }
            return guestMapper.convertToDto(guestRepository.save(guest));
        }
        else {
            throw new EntityNotFoundException("Guest is not available");
        }
    }

    @Override
    public void delete(final long id) {
         Guest guest = guestRepository.findById(id).get();
         guestRepository.delete(guest);
    }
}
