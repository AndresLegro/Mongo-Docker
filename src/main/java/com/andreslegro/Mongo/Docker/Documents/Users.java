package com.andreslegro.Mongo.Docker.Documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
public class Users {
    @Id
    private int id;
    private String name;
    private String email;

}
