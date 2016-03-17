package models;

import org.junit.*;

import static org.junit.Assert.*;

public class KataTest {

    Kata kata;

    @Before
    public void setup(){
        kata = new Kata();
    }

    @Test
    public void itCanGetAndSetAName(){
        kata.candidateName = "John Doe";
        assertEquals(kata.candidateName, "John Doe");
    }

    @Test
    public void itCanGetAndSetAnEmail() {
        kata.candidateEmail = "jdoe@pillartechnology.com";
        assertEquals(kata.candidateEmail, "jdoe@pillartechnology.com");
    }

    @Test
    public void itCanGetAndSetARecruiterEmailAddress(){
        kata.recruiterEmail = "jdoe@pillartechnology.com";
        assertEquals(kata.recruiterEmail, "jdoe@pillartechnology.com");
    }

    @Test
    public void itCanGetAndSetAKataName(){
        kata.name = "Bowling";
        assertEquals(kata.name, "Bowling");
    }

    @Test
    public void itCanGetAndSetALink(){
        kata.url = "http://www.google.com";
        assertEquals(kata.url, "http://www.google.com");
    }
}
