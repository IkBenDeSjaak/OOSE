package nl.han.ica.oose.dea;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdersWriterTest {

    private Orders orders;
    private Order order111;

    @BeforeEach
    void setup() {
        orders = new Orders();
        order111 = new Order(111);

        orders.AddOrder(order111);
    }

    @Test
    void emptyOrdersReturnsCorrectJsonString() {
        // Arrange
        var ordersWriter = new OrdersWriter(new Orders());

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": []}", ordersContent);
    }

    @Test
    void oneOrderReturnsCorrectJsonString() {
        // Arrange
        var order111 = "{\"id\": 111, \"products\": []}";
        var ordersWriter = new OrdersWriter(orders);

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + order111 + "]}", ordersContent);
    }

    @Test
    void twoOrdersReturnsCorrectJsonString() {
        // Arrange
        orders.AddOrder(new Order(222));
        var ordersWriter = new OrdersWriter(orders);

        var order111Json = JsonOrder111WithProduct("");
        var order222Json = "{\"id\": 222, \"products\": []}";

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + order111Json + ", " + order222Json + "]}", ordersContent);
    }

    @Test
    void oneOrderWithOneProductReturnsCorrectJsonString() {
        // Arrange
        order111.AddProduct(new Product("Shirt", 1, 3, 2.99, "TWD"));

        var ordersWriter = new OrdersWriter(orders);

        var order111Json = JsonOrder111WithProduct("{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}");

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + order111Json + "]}", ordersContent);
    }

    @Test
    void oneOrderWithOneProductNoSizeReturnsCorrectJsonString() {
        // Arrange
        order111.AddProduct(new Product("Pot", 2, -1, 16.50, "SGD"));

        var ordersWriter = new OrdersWriter(orders);

        var order111Json = JsonOrder111WithProduct("{\"code\": \"Pot\", \"color\": \"red\", \"price\": 16.5, \"currency\": \"SGD\"}");

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + order111Json + "]}", ordersContent);
    }

    @Test
    void oneOrderWithColorOneAndSizeOneTurnsUpBlueinXSInJsonString()
    {
        // Arrange
        order111.AddProduct(new Product("Shirt", 1, 1, 2.99, "TWD"));

        var ordersWriter = new OrdersWriter(orders);

        var order111Json = JsonOrder111WithProduct("{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"XS\", \"price\": 2.99, \"currency\": \"TWD\"}");

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + order111Json + "]}", ordersContent);
    }

    @Test
    void oneOrderWithColorTwoAndSizeTwoTurnsUpRedinSInJsonString()
    {
        // Arrange
        order111.AddProduct(new Product("Shirt", 2, 2, 2.99, "TWD"));

        var ordersWriter = new OrdersWriter(orders);

        var order111Json = JsonOrder111WithProduct("{\"code\": \"Shirt\", \"color\": \"red\", \"size\": \"S\", \"price\": 2.99, \"currency\": \"TWD\"}");

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + order111Json + "]}", ordersContent);
    }

    @Test
    void oneOrderWithColorThreeAndSizeThreeTurnsUpYellowinMInJsonString()
    {
        // Arrange
        order111.AddProduct(new Product("Shirt", 3, 3, 2.99, "TWD"));

        var ordersWriter = new OrdersWriter(orders);

        var order111Json = JsonOrder111WithProduct("{\"code\": \"Shirt\", \"color\": \"yellow\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}");

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + order111Json + "]}", ordersContent);
    }

    @Test
    void multipleOrdersWithDifferentSizesAndDifferentColorsReturnsCorrectJsonString()
    {
        // Arrange
        order111.AddProduct(new Product("Shirt", 4, 4, 2.99, "TWD"));
        order111.AddProduct(new Product("Shirt", 5, 5, 2.99, "TWD"));
        order111.AddProduct(new Product("Shirt", 6, 6, 2.99, "TWD"));
        order111.AddProduct(new Product("Shirt", 7, 7, 2.99, "TWD"));

        var ordersWriter = new OrdersWriter(orders);

        var order111JsonPart1 = "{\"code\": \"Shirt\", \"color\": \"no color\", \"size\": \"L\", \"price\": 2.99, \"currency\": \"TWD\"}";
        var order111JsonPart2 = "{\"code\": \"Shirt\", \"color\": \"no color\", \"size\": \"XL\", \"price\": 2.99, \"currency\": \"TWD\"}";
        var order111JsonPart3 = "{\"code\": \"Shirt\", \"color\": \"no color\", \"size\": \"XXL\", \"price\": 2.99, \"currency\": \"TWD\"}";
        var order111JsonPart4 = "{\"code\": \"Shirt\", \"color\": \"no color\", \"size\": \"Invalid Size\", \"price\": 2.99, \"currency\": \"TWD\"}";

        // Act
        var ordersContent = ordersWriter.getContents();

        // Assert
        assertEquals("{\"orders\": [" + JsonOrder111WithProduct(order111JsonPart1 + ", " + order111JsonPart2 + ", " + order111JsonPart3 + ", " + order111JsonPart4) + "]}", ordersContent);
    }



    private String JsonOrder111WithProduct(String productJson) {
        return "{\"id\": 111, \"products\": [" + productJson + "]}";
    }
}
