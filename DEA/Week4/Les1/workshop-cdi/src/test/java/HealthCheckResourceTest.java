import nl.han.ica.oose.dea.resources.HealthCheckResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HealthCheckResourceTest {

    @Test
    public void isHealthy() {
        //Arrange
        HealthCheckResource healthCheckResource = new HealthCheckResource();

        //Act
        String result = healthCheckResource.healthy();

        //Assert
        Assertions.assertEquals("Up & Running", result);
    }
}
