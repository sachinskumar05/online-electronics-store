package com.sk.estore.services;

import com.sk.estore.persistence.data.Item;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class MongoPersistenceService {

    @Autowired
    MongoTemplate mongoTemplate;

    //CREATE
    public void createItems(Item item) {
        log.info("Data creation started...");
        mongoTemplate.insert(item);
        log.info("Data creation complete...");
    }
    // READ
    public List<Item> getAllItems() {
        return mongoTemplate.findAll(Item.class);
    }

    public List<Item> getItemByName(String name) {
        log.debug("Getting item by name: " + name);
        List<Item> items = mongoTemplate.find(Query.query(Criteria.where("name").is(name)), Item.class);
        log.debug("Found {}", items);
        return items;
    }

    public List<Item> getItemById(String id) {
        log.debug("Getting item by id: " + id);
        List<Item> items = mongoTemplate.find(Query.query(Criteria.where("id").is(id)), Item.class);
        log.debug("Found {}", items);
        return items;
    }

    // 3. Get name and quantity of a all items of a particular category
    public List<Item> getItemsByCategory(String category) {
        log.debug("Getting items for the category " + category);
        List<Item> list = mongoTemplate.find( Query.query(Criteria.where("category").is(category)), Item.class );
        list.forEach(item -> log.debug("Name: " + item.getName() + ", Stock: " + item.getStock()));
        return  list;
    }

    // 4. Get count of documents in the collection
    public long findCountOfItems() {
        long count = mongoTemplate.count(Query.query(Criteria.where("name").exists(true)) , Item.class);
        log.info("Number of documents in the collection: " + count);
        return count;
    }

    // Print details in readable form
    public String getItemDetails(Item item) {
        return String.format("Item Name: %s, Quantity: %s, Item Category: %s"
                , item.getName()
                , item.getStock()
                , item.getCategory());
    }

    public void updateCategoryName(String category, String newCategory) {

        // Find all the items with the category snacks
        List<Item> list = mongoTemplate.find(Query.query(Criteria.where("category").is(category)), Item.class);

        list.forEach(item -> {
            // Update the category in each document
            item.setCategory(newCategory);
        });

        // Save all the items in database
        List<Item> itemsUpdated = (List<Item>) mongoTemplate.insertAll(list);

        log.info("Successfully updated " + itemsUpdated.size() + " items.");
    }

    // DELETE
    public void deleteItem(String id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)));
        log.info("Item with id " + id + " deleted...");
    }

    public void deleteAllItems() {
        mongoTemplate.remove(Item.class).findAndRemove();
        log.info("All Items deleted... {} ", (mongoTemplate.findAll(Item.class).isEmpty()) );
    }

}
