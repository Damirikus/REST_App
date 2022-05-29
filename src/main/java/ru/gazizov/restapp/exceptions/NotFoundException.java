package ru.gazizov.restapp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //возвращает http ответ с соответсвующим статусом
public class NotFoundException extends RuntimeException{

}
