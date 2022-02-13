package com.sk.estore.persistence.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Baskets")
public class Basket {
    @Id
    private String id;

    List<Item> itemsList;
}
