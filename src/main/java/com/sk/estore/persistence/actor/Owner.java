package com.sk.estore.persistence.actor;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import static com.sk.estore.util.JsonUtils.*;

@Document("Owner")
@Getter
public class Owner {

    @Id
    private String id;
    private String name;
    private int age;

    public Owner(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return GSON.toJson(this);
    }

    public Owner of(String jsonString) {
        return GSON.fromJson(jsonString, Owner.class);
    }

}
