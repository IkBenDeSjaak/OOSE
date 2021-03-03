package nl.han.ica.oose.dea.datasource;

import nl.han.ica.oose.dea.datasource.util.DatabaseProperties;
import nl.han.ica.oose.dea.datasource.util.ScriptRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ItemDaoTest {
    private ItemDao itemDao;

    @BeforeEach
    public void setup() throws SQLException, IOException {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
        ScriptRunner scriptRunner = new ScriptRunner(connection, true, true);
        scriptRunner.runScript(new InputStreamReader(ClassLoader.getSystemResourceAsStream("import.sql")));
        connection.close();

        itemDao = new ItemDao(databaseProperties);
    }

    @Test
    public void findAllShouldReturnOneItem() {
        Assertions.assertEquals(1, itemDao.findAll().size());
    }
}
