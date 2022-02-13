package com.sk.estore.persistence.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@ToString
@Document("Items")
public class Item {
    @Id
    private String id;

    private String name;

    private int stock;

    private int price;

    @Setter
    private String category;
    @Setter
    private double discountPercent;
    @Setter
    private List<String> freeItems;
    @Setter
    private boolean isActive=true;

    public Item(String id, String name, int stock, int price, String category ) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price= price;
        this.category = category;
    }

    public Item buy(int qty) {
        this.stock -= qty;
        return this;
    }


}
