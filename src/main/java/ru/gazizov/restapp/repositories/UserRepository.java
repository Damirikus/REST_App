package ru.gazizov.restapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gazizov.restapp.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
