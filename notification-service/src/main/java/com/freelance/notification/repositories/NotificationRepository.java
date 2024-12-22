package com.freelance.notification.repositories;

import com.freelance.notification.entities.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository  extends MongoRepository<Notification,String> {
}
