package com.hshl.messagAPI.messageAPI.controller;

import com.hshl.messagAPI.messageAPI.model.Message;
import com.hshl.messagAPI.messageAPI.model.SubMessage;
import com.hshl.messagAPI.messageAPI.repository.MessageRepository;
import com.hshl.messagAPI.messageAPI.repository.SubMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messageData")
public class MessageController {

    @Autowired
    MessageRepository repository;
    @Autowired
    SubMessageRepository subMessageRepository;

    @GetMapping("")
    public List<Message> getAll(@RequestParam String topic){
        return repository.findByTopic(topic);
    }

    @PostMapping(value ="/newMessage",consumes= "application/json", produces = "application/json")
    public Message save(@RequestBody Message newMessage){
        Message message = new Message();
        message.setMainMessage(newMessage.getMainMessage());
        message.setUsername(newMessage.getUsername());
        message.setTopic(newMessage.getTopic());
        return repository.save(message);
    }

    @PostMapping(value ="/subMessage",consumes= "application/json", produces = "application/json")
    public SubMessage saveSubMessage(@RequestBody SubMessage newSubMessage){
        SubMessage subMessage = new SubMessage();
        subMessage.setSubMessage(newSubMessage.getSubMessage());
        subMessage.setUsername(newSubMessage.getUsername());
        subMessage.setParent(newSubMessage.getParent());
        return subMessageRepository.save(subMessage);
    }

    @GetMapping("/{id}")
    public Optional<Message> getById(@PathVariable Long id){
        return repository.findById(id);
    }

}
