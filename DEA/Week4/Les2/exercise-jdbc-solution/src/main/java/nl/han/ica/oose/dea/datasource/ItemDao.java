package nl.han.ica.oose.dea.datasource;

import nl.han.ica.oose.dea.domain.Item;
import nl.han.ica.oose.dea.datasource.util.DatabaseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDao {
    private Logger logger = Logger.getLogger(getClass().getName());

    private DatabaseProperties databaseProperties;

    public ItemDao(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item(resultSet.getInt("id"),
                        resultSet.getString("sku"), resultSet.getString("category"), resultSet.getString("title")
                );
                items.add(item);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return items;
    }

    public boolean addItem(Item item) {
        try (Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO items (category, sku, title) VALUES (?, ?, ?)");
            statement.setString(1, item.getCategory());
            statement.setString(2, item.getSku());
            statement.setString(3, item.getTitle());
            return statement.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Can't insert item " + item, e);
        }
        return false;
    }

    public boolean deleteItem(int id) {
        try (Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");
            statement.setInt(1, id);
            return statement.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Can't delete item with id " + id, e);
        }
        return false;
    }
}
