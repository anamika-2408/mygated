package com.example.mygatedsociety.mapper;

import com.example.mygatedsociety.dto.GuestDto;
import com.example.mygatedsociety.model.Guest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GuestMapper {
     Guest convertToEntity(GuestDto guestDto);
     List<Guest> convertListToEntity(List<GuestDto> guests);

     GuestDto convertToDto(Guest guest);
     List<GuestDto> convertListToDto(List<Guest> guests);
}
