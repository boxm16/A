/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.ItemDao;
import Models.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 *
 * @author Michail Sitmalidis
 */
public class ItemController {

    ItemDao itemDao;

    public ItemController() {

        itemDao = new ItemDao();
    }

    private ArrayList<Item> getCustomerItems(int customerId) {
        ArrayList<Item> customerItems;

        customerItems = itemDao.getCustomerItems(customerId);

        for (Item item : customerItems) {
            if (item.getLength() != null && item.getWidth() != null) {
                BigDecimal length = item.getLength();
                BigDecimal width = item.getWidth();
                BigDecimal square = length.multiply(width).setScale(2, RoundingMode.HALF_EVEN);
                if (item.isForCleaning()) {

                    BigDecimal price = item.getCleaningPrice();
                    BigDecimal charge = square.multiply(price).setScale(2, RoundingMode.HALF_EVEN);

                    item.setCleaningCharge(charge);
                } else {
                    item.setCleaningCharge(BigDecimal.ZERO);
                }
                if (item.isForStoring()) {
                    BigDecimal price = item.getStoringPrice();
                    BigDecimal charge = square.multiply(price).setScale(2, RoundingMode.HALF_EVEN);
                    item.setStoringCharge(charge);
                } else {
                    item.setStoringCharge(BigDecimal.ZERO);
                }

            } else {
                item.setCleaningCharge(BigDecimal.ZERO);
                item.setStoringCharge(BigDecimal.ZERO);

            }
            if (item.getMendingCharge() == null) {
                item.setMendingCharge(BigDecimal.ZERO);
            }

        }

        return customerItems;
    }

    public ArrayList<Item> getCustomerItemsForCard(int customerId) {
        ArrayList<Item> itemsForCard = new ArrayList<>();
        ArrayList<Item> customerItems = getCustomerItems(customerId);

        for (Item item : customerItems) {
            if (item.getStatus().equals("processing") | item.getStatus().equals("ready")) {
                itemsForCard.add(item);

            }
        }
        return itemsForCard;
    }

    public ArrayList<Item> getCustomerItemsForOnRoutCard(int customerId) {
        ArrayList<Item> itemsForOnRoutCard = new ArrayList<>();
        ArrayList<Item> customerItems = getCustomerItems(customerId);

        for (Item item : customerItems) {
            if (item.getStatus().equals("on_rout")) {
                itemsForOnRoutCard.add(item);

            }
        }
        return itemsForOnRoutCard;
    }

    public boolean itemCodeRegisteredInDb(int itemCode) {
        return itemDao.itemCodeRegisteredInDb(itemCode);

    }

    public Item getItemByCode(String code, String year) {
        return itemDao.getItemByCode(code, year);
    }

    public void updateItemDimensions(Item item) {
        itemDao.updateItemDimensions(item);
    }

    public void updateItemMendingCharge(Item item) {
        itemDao.updateItemMendingCharge(item);
    }

}
