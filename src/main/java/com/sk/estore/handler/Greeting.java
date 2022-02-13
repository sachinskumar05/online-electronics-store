package com.sk.estore.handler;


import com.sk.estore.persistence.data.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Greeting {


    private long id= System.nanoTime();
    private List<Item> itemList = new ArrayList<>();
    private List<String> itemIds = new ArrayList<>();
    private String content;

    public long getId() {
        return id;
    }

    public void setItems(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItems() {
        return itemList;
    }

    public List<String>  getItemIds() {
        return this.itemIds;
    }
    public void  setItemIds(List<String> itemIds) {
        this.itemIds= itemIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
