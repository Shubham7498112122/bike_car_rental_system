package com.example.demo.controller;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Owner;
import com.example.demo.services.BookingService;
import com.example.demo.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;
    
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerService.getAllOwners();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable("id") int id) {
        return ownerService.getAllOwners().stream()
                .filter(owner -> owner.getOwnerId() == id)
                .findFirst()
                .map(owner -> new ResponseEntity<>(owner, HttpStatus.OK))//transform Optional<Customer> to Response Entity<Customer>
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<Owner> getOwnerByUserId(@PathVariable("userId") int userId) {
        Optional<Owner> owner = ownerService.getOwnerByUserId(userId);
        return owner.map(o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
        Owner savedOwner = ownerService.saveOwner(owner);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }
    @GetMapping("/{ownerId}/bookings")
    public ResponseEntity<List<Booking>> getOwnerBookings(@PathVariable Integer ownerId) {
        List<Booking> bookings = bookingService.getBookingsByOwner(ownerId);
        return ResponseEntity.ok(bookings);
    }
}
