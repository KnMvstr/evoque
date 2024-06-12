package com.knmvstr.evoque.service.mapper;

import com.knmvstr.evoque.controller.EventPurchaseResponse;
import com.knmvstr.evoque.controller.EventRequest;
import com.knmvstr.evoque.controller.EventResponse;
import com.knmvstr.evoque.entity.Category;
import com.knmvstr.evoque.entity.Event;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {
    public Event toEvent(EventRequest request) {
        return Event.builder()
                .id(request.id())
                .title(request.title())
                .description(request.description())
                .price(request.price())
                .availableQtty(request.availableQtty())
                .image(request.image())
                .category(
                        Category.builder()
                                .id(request.id())
                                .build())
                .startTime(request.startTime())
                .endTime(request.endTime())
                .build();
    }

    public EventResponse toEventResponse(Event event) {
        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getImage(),
                event.getAvailableQtty(),
                event.getEndTime(),
                event.getStartTime(),
                event.getPrice(),
                event.getCategory().getId(),
                event.getCategory().getTitle(),
                event.getCategory().getDescription()
        );
    }

    public EventPurchaseResponse toEventPurchaseResponse(Event event, double availableQtty) {
        return new EventPurchaseResponse(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getImage(),
                event.getAvailableQtty(),
                event.getEndTime(),
                event.getStartTime(),
                event.getPrice()
        );
    }
}
