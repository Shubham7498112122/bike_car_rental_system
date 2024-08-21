package com.example.demo.repositories;

import com.example.demo.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByCustomer_CustomerId(int customerId);
    @Query("SELECT b FROM Booking b WHERE b.vehicle.owner.ownerId = :ownerId")
    List<Booking> findByOwnerId(@Param("ownerId") Integer ownerId);
}
