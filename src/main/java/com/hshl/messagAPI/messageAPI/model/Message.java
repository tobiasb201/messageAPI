package com.hshl.messagAPI.messageAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    private String username;

    private String mainMessage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    List<SubMessage> subMessages;

}


