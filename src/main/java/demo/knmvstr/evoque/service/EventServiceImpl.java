package demo.knmvstr.evoque.service;

import demo.knmvstr.evoque.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImpl {
    @Autowired
    private EventRepository eventRepository;
}