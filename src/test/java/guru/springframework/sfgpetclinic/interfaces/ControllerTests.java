package guru.springframework.sfgpetclinic.interfaces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag(value = "controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllerTests {

    @BeforeAll
    default void beforeAll(){
        System.out.println("Lets do something here");
    }
}
