package com.hshl.messagAPI.messageAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class SubMessage{

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int parent;

    private String username;

    private String subMessage;

}
