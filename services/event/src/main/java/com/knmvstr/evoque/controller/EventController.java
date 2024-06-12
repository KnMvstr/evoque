package com.knmvstr.evoque.controller;

import com.knmvstr.evoque.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

 private final EventService eventService;

 @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody @Valid EventRequest request) {
     return ResponseEntity.ok(eventService.createEvent(request));
 }

 @PostMapping("/purchase")
    public ResponseEntity<List<EventPurchaseResponse>> purchaseEvent(@RequestBody List<EventPurchaseResquest> request) {
     return ResponseEntity.ok(eventService.purchaseEvents(request));
 }

 @GetMapping("/{id}")
    public ResponseEntity<EventResponse> findById(@PathVariable("event_id") Integer eventId){
     return ResponseEntity.ok(eventService.findById(eventId));
 }

    @GetMapping
    public ResponseEntity<List<EventResponse>> findAll(){
     return ResponseEntity.ok(eventService.findAll());
    }
}
