package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.interfaces.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest implements ControllerTests {

    IndexController indexController = new IndexController();

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test Properties View name is returned for index page")
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong View Returned");
        assertThat("index").isEqualTo(indexController.index());
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equalsIgnoreCase(indexController.oupsHandler()), () -> "Something went wrong");

        assertTrue("notimplemented".equalsIgnoreCase(indexController.oupsHandler()), new Supplier<String>() {
            @Override
            public String get() {
                return "Something went wrong";
            }
        });


    }

    @Test
    @DisplayName("Test ValueNotFoundException Throws")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> indexController.oopsHandler());
    }

    @Disabled("Demo of Timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("Test TimeOut end");
        });
    }

    @Disabled("Demo of Timeout")
    @Test
    void testTimeOut2() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("Test TimeOut2 end");
        });
    }

    @Test
    void testAssumptionsTrue() {
        //Если пользователь не Iskander, то тест проинорируется
        Assumptions.assumeTrue("Iskander".equalsIgnoreCase(System.getenv("user")));
    }


    @Test
    void testAssumptionsTrue2() {
        //Если пользователь не Iskander, то тест проинорируется
        Assumptions.assumeTrue("Iskander".equalsIgnoreCase("Iskander"));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMacOs() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava17() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Iskander")
    void testIfUserIskander() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Roma")
    void testIfUserRoma() {

    }

    @Test
    void testNumber(){
        int number = 5;
        assertTrue(number>5);
        assertTrue(number%2!=0, () -> "Number "+ number +" is not odd");
    }
}