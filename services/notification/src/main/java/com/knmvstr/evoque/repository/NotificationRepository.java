package com.knmvstr.evoque.repository;

import com.knmvstr.evoque.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
}
