package ru.gazizov.restapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gazizov.restapp.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
