package com.sk.estore.services;

import com.sk.estore.handler.Basket;
import com.sk.estore.persistence.data.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private MongoPersistenceService mongoPersistenceService;

    @GetMapping("/basket")
    public String greetingForm(Model model) {
        List<Item> itemList = mongoPersistenceService.getAllItems();
        model.addAttribute("itemList", itemList);
        model.addAttribute("basket", new Basket());
        return "basket";
    }

    @PostMapping("/basket")
    public String greetingSubmit(@ModelAttribute Basket basket, Model model) {
        model.addAttribute("basket", basket);
        return "result";
    }

    @PostMapping("/owner")
    public String ownerForm(@ModelAttribute Basket basket, Model model) {
        model.addAttribute("basket", basket);
        return "result";
    }
}
