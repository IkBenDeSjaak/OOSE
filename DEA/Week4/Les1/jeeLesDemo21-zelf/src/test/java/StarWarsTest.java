import oose.dea.dao.IJediDAO;
import oose.dea.dao.JediDAO;
import oose.dea.domain.Jedi;
import oose.dea.service.StarWars;
import oose.dea.service.dto.JediDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StarWarsTest {

    private StarWars starWars;

    @BeforeEach
    public void setUp() {
        starWars = new StarWars();
//        JediDAO jediDAO = new JediDAO();
//        starWars.setJediDAO(jediDAO);
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

        Jedi jedi = new Jedi(41);
        jedi.setName("Thijmen");

        IJediDAO jediDAOMock = mock(IJediDAO.class);
        when(jediDAOMock.getJedi(41)).thenReturn(jedi);
        starWars.setJediDAO(jediDAOMock);

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
        int id = 41;

        IJediDAO jediDAOMock = mock(IJediDAO.class);
        when(jediDAOMock.getJedi(41)).thenReturn(null);
        starWars.setJediDAO(jediDAOMock);

        //Act
        Response result = starWars.getJedi(id);

        //Assert
        Assertions.assertEquals(statusCode, result.getStatus());
    }
}
