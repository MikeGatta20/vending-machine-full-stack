package com.techelevator.controller;

import com.techelevator.dao.VendingItemDAO;
import com.techelevator.model.VendingItem;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class VendingItemController {
    private VendingItemDAO vendingItemDAO;

    public VendingItemController(VendingItemDAO vendingItemDAO) {
        this.vendingItemDAO = vendingItemDAO;
    }

    @GetMapping(path = "/all-vending-items")
    public List<VendingItem> getAllVendingItems() {
        return vendingItemDAO.getAllVendingItems();
    }

    @GetMapping(path = "/vending-item/{id}")
    public VendingItem getVendingItemById(@PathVariable int id) {
        return vendingItemDAO.getVendingItemById(id);

    }
}
