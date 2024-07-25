package com.techelevator.dao;

import com.techelevator.model.VendingItem;

import java.util.List;

public interface VendingItemDAO {
    public List<VendingItem> getAllVendingItems();
    public VendingItem getVendingItemById(int id);

}
