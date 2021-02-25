import oose.dea.StarWars;
import oose.dea.oose.dea.dto.JediDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class StarWarsTest {

    private StarWars starWars;

    @BeforeEach
    public void setUp() {
        starWars = new StarWars();
    }

    @Test
    public void helloWorldTest() {
        //Arrange
        String expected = "May the force be with you, Luke!";

        //Act
        String result = starWars.helloWorld();

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getJediTest() {
        //Arrange
        int statusCode = 200;
        int id = 41;
        String name = "Thijmen";

        //Act
        Response result = starWars.getJedi(id);
        JediDTO jediDTO = (JediDTO) result.getEntity();

        //Assert
        Assertions.assertEquals(statusCode, result.getStatus());
        Assertions.assertEquals(id, jediDTO.customerId);
        Assertions.assertEquals(name, jediDTO.name);
    }

    @Test
    public void getJediNotFoundTest() {
        //Arrange
        int statusCode = 404;
        int id = 39;

        //Act
        Response result = starWars.getJedi(id);
        String responseString = (String) result.getEntity();

        //Assert
        Assertions.assertEquals(statusCode, result.getStatus());
        Assertions.assertEquals("niet gevonden", responseString);
    }
}
