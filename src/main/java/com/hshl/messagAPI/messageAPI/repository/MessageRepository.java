package com.hshl.messagAPI.messageAPI.repository;

import com.hshl.messagAPI.messageAPI.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value="Select * FROM Message WHERE topic =:topic",nativeQuery = true)
    List<Message> findByTopic(String topic);

}
