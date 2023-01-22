package com.example.mygatedsociety.repository;

import com.example.mygatedsociety.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long > {
    List<Guest> findByEntryTimeBetween(LocalDateTime start, LocalDateTime end);
}
