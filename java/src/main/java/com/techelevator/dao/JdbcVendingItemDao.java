package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.VendingItem;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVendingItemDao implements VendingItemDAO {


    private final JdbcTemplate jdbcTemplate;

    public JdbcVendingItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<VendingItem> getAllVendingItems() {

        List<VendingItem> vendingItems = new ArrayList<>();
        String sql = "SELECT * FROM vending_machine";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                vendingItems.add(mapResultsToVendingItem(results));
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(LocalDateTime.now() + " [Jdbc Vending Item] Cannot access database.");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException(LocalDateTime.now() + " [Jdbc Vending Item] Bad data.");
        }

        return vendingItems;
    }

    @Override
    public VendingItem getVendingItemById(int id) {

        VendingItem vendingItem = new VendingItem();
        String sql = "SELECT * FROM vending_machine WHERE item_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()){
                vendingItem = mapResultsToVendingItem(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(LocalDateTime.now() + " [Jdbc Vending Item] Cannot access database.");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException(LocalDateTime.now() + " [Jdbc Vending Item] Bad data.");
        }

        return vendingItem;


    }

    private VendingItem mapResultsToVendingItem(SqlRowSet results) {
        return new VendingItem(
                results.getString("location"),
                results.getInt("item_id"),
                results.getString("name"),
                results.getString("type"),
                results.getInt("price"),
                results.getInt("inventory")
        );
    }

}
