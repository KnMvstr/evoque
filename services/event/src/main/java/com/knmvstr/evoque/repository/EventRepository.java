package com.knmvstr.evoque.repository;

import com.knmvstr.evoque.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByIdInOrderById(List<Long> eventIds);
}
