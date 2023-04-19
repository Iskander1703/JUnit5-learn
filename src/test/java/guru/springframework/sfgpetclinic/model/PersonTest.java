package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag(value = "model")
class PersonTest {

    @Test
    void groupAssertions(){
        //give
        Person person=new Person(1l, "Joe","Buck");
        //then

        assertAll("TestProps Set",
                ()-> assertEquals("Joe",person.getFirstName()),
                ()-> assertEquals("Buck",person.getLastName()),
                ()-> assertEquals(Long.valueOf(1),person.getId()));
    }

    @Test
    void groupAssertions2(){
        //give
        Person person=new Person(1l, "Joe","Buck");
        //then

        assertAll("TestProps Set",
                ()-> assertEquals("Joe2",person.getFirstName(),"First name failed"),
                ()-> assertEquals("Buck2",person.getLastName(), "Second name failed"),
                ()-> assertEquals(Long.valueOf(2),person.getId(), "Id failed"));
    }

}