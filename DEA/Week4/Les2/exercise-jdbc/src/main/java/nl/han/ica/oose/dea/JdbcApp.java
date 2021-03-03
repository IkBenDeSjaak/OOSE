package nl.han.ica.oose.dea;

import nl.han.ica.oose.dea.datasource.ItemDao;
import nl.han.ica.oose.dea.datasource.util.DatabaseProperties;
import nl.han.ica.oose.dea.domain.Item;

import java.io.IOException;
import java.util.List;

public class JdbcApp {
    public static void main(String[] args) throws IOException {
        ItemDao itemDao = new ItemDao(new DatabaseProperties());
        Item item = new Item("Kroket", "Snacks", "Lekker in bed");

        printAllItems(itemDao);
        addNewItem(itemDao, item);
        printAllItems(itemDao);
        deleteLatestAddedItem(itemDao, item);
        printAllItems(itemDao);

    }

    private static void deleteLatestAddedItem(ItemDao itemDao, Item item) {
        Item foundItem = itemDao.findAll().stream().filter(i -> i.getSku().equals(item.getSku())).findFirst().get();
        itemDao.deleteItem(foundItem.getId());
    }

    private static void addNewItem(ItemDao itemDao,Item item) {
        itemDao.addItem(item);
    }

    private static void printAllItems(ItemDao itemDao) {
        List<Item> items = itemDao.findAll();
        for(Item item:items)
            System.out.println(item);
    }
}
