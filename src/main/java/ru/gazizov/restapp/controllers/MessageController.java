package ru.gazizov.restapp.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import ru.gazizov.restapp.model.Message;
import ru.gazizov.restapp.model.Views;
import ru.gazizov.restapp.repositories.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list(){
        return messageRepository.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    //@RequestBody, Spring на лету попытается преобразовать содержимое тела входящего запроса в ваш объект параметра.
    @PostMapping
    public Message create(@RequestBody Message message){
        message.setTime(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageExists,
                          @RequestBody Message message){

        BeanUtils.copyProperties(message, messageExists, "id");
        return messageRepository.save(messageExists);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message){
        messageRepository.delete(message);
    }

}
