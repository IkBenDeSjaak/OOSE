import nl.han.ica.oose.dea.resources.ItemResource;
import nl.han.ica.oose.dea.services.dto.ItemDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class ItemResourceTest {

    private ItemResource itemResource;

    @BeforeEach
    void setup() {
        this.itemResource = new ItemResource();
    }

    @Test
    public void getTextItemsTest() {
        // Arrange

        // Act
        String response = itemResource.getTextItems();

        // Assert
        Assertions.assertEquals("bread, butter", response);
    }

    @Test
    public void getJsonItemsTest() {
        // Arrange


        // Act
        Response response = itemResource.getJsonItems();

        // Assert
        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertTrue(response.getEntity() instanceof List);
    }

    @Test
    public void addItemTest() {
        //Arrange
        ItemDTO item = new ItemDTO(4, "Bread", new String[]{"Breakfast, Lunch"}, "Delicious!");

        //Act
        Response response = itemResource.addItem(item);

        //Assert
        Assertions.assertEquals(201, response.getStatus());
    }

    @Test
    public void getItemTest() {
        //Arrange


        //Act
        Response response = itemResource.getItem(1);
        ItemDTO item = (ItemDTO) response.getEntity();

        //Assert
        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertTrue(response.getEntity() instanceof ItemDTO);

        Assertions.assertEquals(1, item.getId());

    }

    @Test
    public void deleteItemTest() {
        // Act
        Response response = itemResource.deleteItem(3);

        //Assert
        Assertions.assertEquals(200, response.getStatus());
    }
}
