import nl.han.ica.oose.dea.resources.ItemResource;
import nl.han.ica.oose.dea.services.ItemService;
import nl.han.ica.oose.dea.services.dto.ItemDTO;
import nl.han.ica.oose.dea.services.exceptions.IdAlreadyInUseException;
import nl.han.ica.oose.dea.services.exceptions.ItemNotAvailableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class ItemResourceTest {

    private ItemResource sut;
    private ItemService mockedItemService;

    @BeforeEach
    void setup() {
        this.sut = new ItemResource();

        // Gebruik Mockito om een instantie te maken
        this.mockedItemService = Mockito.mock(ItemService.class);

        // Gebruik de setter om de mockedItemService te zetten
        this.sut.setItemService(mockedItemService);
    }

    @Test
    public void getTextItemsTest() {
        // Arrange
        String textItems = "bread, butter";

        // Act
        String response = sut.getTextItems();

        // Assert
        Assertions.assertEquals(textItems, response);
    }

    @Test
    public void getJsonItemsCallsGetAll() {
        //Arrange

        //Act
        sut.getJsonItems();

        //Assert
        Mockito.verify(mockedItemService).getAll();
    }

    @Test
    public void getJsonReturnsObjectFromServiceAsEntity() {
        //Arrange
        ArrayList<ItemDTO> itemsToReturn = new ArrayList<ItemDTO>();
        Mockito.when(mockedItemService.getAll()).thenReturn(itemsToReturn);

        //Act
        Response response = sut.getJsonItems();

        //Assert
        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(itemsToReturn, response.getEntity());

    }

    @Test
    public void addItemsCallsAddItem() {
        //Arrange
        ItemDTO item = new ItemDTO(4, "Bread", new String[]{"Breakfast, Lunch"}, "Delicious!");

        //Act
        sut.addItem(item);

        //Assert
        Mockito.verify(mockedItemService).addItem(item);
    }

    @Test
    public void addItemReturns201() {
        //Arrange
        ItemDTO item = new ItemDTO(4, "Bread", new String[]{"Breakfast, Lunch"}, "Delicious!");

        //Act
        Response response = sut.addItem(item);

        //Assert
        Assertions.assertEquals(201, response.getStatus());
    }

    @Test
    public void addItemIdAlreadyInUseException() {
        //Arrange
        ItemDTO item = new ItemDTO(4, "Bread", new String[]{"Breakfast, Lunch"}, "Delicious!");
        Mockito.doThrow(IdAlreadyInUseException.class).when(mockedItemService).addItem(item);

        //Act

        //Assert
        Assertions.assertThrows(IdAlreadyInUseException.class, () -> sut.addItem(item));
    }

    @Test
    public void getItemCallsGetItem() {
        //Arrange
        int itemID = 1;

        //Act
        sut.getItem(itemID);

        //Assert
        Mockito.verify(mockedItemService).getItem(itemID);
    }

    @Test
    public void getItemReturnsObjectFromServiceAsEntity() {
        //Arrange
        int itemID = 1;
        ItemDTO item = new ItemDTO(itemID, "Bread", new String[]{"Breakfast, Lunch"}, "Delicious!");
        Mockito.when(mockedItemService.getItem(itemID)).thenReturn(item);

        //Act
        Response response = sut.getItem(itemID);

        //Assert
        Assertions.assertEquals(item, response.getEntity());
    }

    @Test
    void getItemGivesItemNotAvailableException() {

        // Arrange
        int itemID = 1;
        Mockito.doThrow(ItemNotAvailableException.class).when(mockedItemService).getItem(itemID);

        // Act & Assert
        Assertions.assertThrows(ItemNotAvailableException.class, () -> sut.getItem(itemID));
    }

    @Test
    public void deleteItemCallsDeleteItem() {
        //Arrange
        int itemID = 1;

        //Act
        sut.deleteItem(itemID);

        //Assert
        Mockito.verify(mockedItemService).deleteItem(itemID);
    }

    @Test
    public void deleteItemReturns200() {
        //Arrange
        int itemID = 1;

        //Act
        Response response = sut.deleteItem(itemID);

        //Assert
        Assertions.assertEquals(200, response.getStatus());

    }

    @Test
    void deleteItemLetsItemNotAvailableExceptionPass() {
        // Arrange
        int itemID = 1;
        Mockito.doThrow(ItemNotAvailableException.class).when(mockedItemService).deleteItem(itemID);

        // Act & Assert
        Assertions.assertThrows(ItemNotAvailableException.class, () -> sut.deleteItem(itemID));
    }

//    @Test
//    public void getJsonItemsTest() {
//        // Arrange
//
//
//        // Act
//        Response response = sut.getJsonItems();
//
//        // Assert
//        Assertions.assertEquals(200, response.getStatus());
//        Assertions.assertTrue(response.getEntity() instanceof List);
//    }

//    @Test
//    public void addItemTest() {
//        //Arrange
//        ItemDTO item = new ItemDTO(4, "Bread", new String[]{"Breakfast, Lunch"}, "Delicious!");
//
//        //Act
//        Response response = sut.addItem(item);
//
//        //Assert
//        Assertions.assertEquals(201, response.getStatus());
//    }
//
//    @Test
//    public void getItemTest() {
//        //Arrange
//
//
//        //Act
//        Response response = sut.getItem(1);
//        ItemDTO item = (ItemDTO) response.getEntity();
//
//        //Assert
//        Assertions.assertEquals(200, response.getStatus());
//        Assertions.assertTrue(response.getEntity() instanceof ItemDTO);
//
//        Assertions.assertEquals(1, item.getId());
//
//    }
//
//    @Test
//    public void deleteItemTest() {
//        // Act
//        Response response = sut.deleteItem(3);
//
//        //Assert
//        Assertions.assertEquals(200, response.getStatus());
//    }
}
