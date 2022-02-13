package com.sk.estore.services;

import com.sk.estore.handler.Greeting;
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

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        List<Item> itemList = mongoPersistenceService.getAllItems();
        model.addAttribute("itemList", itemList);
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

    @PostMapping("/owner")
    public String ownerForm(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }
}
