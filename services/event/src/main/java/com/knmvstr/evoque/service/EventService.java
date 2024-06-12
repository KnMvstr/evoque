package com.knmvstr.evoque.service;

import com.knmvstr.evoque.controller.EventPurchaseResponse;
import com.knmvstr.evoque.controller.EventPurchaseResquest;
import com.knmvstr.evoque.controller.EventRequest;
import com.knmvstr.evoque.controller.EventResponse;
import com.knmvstr.evoque.custom_response.EventPurchaseException;
import com.knmvstr.evoque.repository.EventRepository;
import com.knmvstr.evoque.service.mapper.EventMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public List<EventResponse> findAll(){
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toEventResponse)
                .collect(Collectors.toList());
    };

    public Long createEvent(EventRequest request) {
       var event=eventMapper.toEvent(request);
       return eventRepository.save(event).getId();
    }

    // Extract a list of eventIds ->Check if the amount of wanted event are available in DB
    // If there is a difference I send an Exception.
    // I store the Ids of the request into a list to compare it to the available quantity.

    public List<EventPurchaseResponse> purchaseEvents(List<EventPurchaseResquest> request) {
        var eventIds=request.stream()
                .map(EventPurchaseResquest::eventId)
                .toList();
        var storedEvents=eventRepository.findAllByIdInOrderById(eventIds);
        if(eventIds.size()!=storedEvents.size()){
            //If user wants more events than the available size available in DB he gets a Exception
            throw new EventPurchaseException("One or more places are unavailable") ;
        }
        var storeRequest=request.stream()
                .sorted(Comparator.comparing(EventPurchaseResquest::eventId))
                .toList();
        var purchasedEvents= new ArrayList<EventPurchaseResponse>();
        for(int i=0; i<storedEvents.size(); i++){
            var event=storedEvents.get(i);
            var eventRequest = storedEvents.get(i);
            if (event.getAvailableQtty() < eventRequest.getAvailableQtty()){
                throw new EventPurchaseException("Unsufficient available quantity") ;
            }
            //Updating the qtty
            var newAvailableQuantity=event.getAvailableQtty()-eventRequest.getAvailableQtty();
            event.setAvailableQtty(newAvailableQuantity);
            eventRepository.save(event);
            purchasedEvents.add(eventMapper.toEventPurchaseResponse(event, eventRequest.getAvailableQtty()));
        }
        return purchasedEvents;
    }

    public EventResponse findById(Integer eventId) {
        return eventRepository.findById(eventId)
                .map(eventMapper::toEventResponse)
                .orElseThrow(()-> new EntityNotFoundException("Event not found with ID:: " + eventId));
    }
}
