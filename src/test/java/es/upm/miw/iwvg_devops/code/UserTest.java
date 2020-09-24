package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        this.user = new User("id","name","familyName",new ArrayList<>());
    }

    @Test
    void testCreateUser() {
        User user = new User();
        assertEquals(new ArrayList<>(), user.getFractions());
    }

    @Test
    void testCreateUserWithParams() {
        User user = new User("id","name","familyName",new ArrayList<>());
        assertEquals("id", user.getId());
        assertEquals("name", user.getName());
        assertEquals("familyName", user.getFamilyName());
        assertEquals(new ArrayList<>(), user.getFractions());
    }

    @Test
    void checkGetUserId() {
        assertEquals("id", this.user.getId());
    }

    @Test
    void checkGetUserName() {
        assertEquals("name", this.user.getName());
    }

    @Test
    void checkGetUserFamilyName() {
        assertEquals("familyName", this.user.getFamilyName());
    }

    @Test
    void checkGetUserFractions() {
        assertEquals(new ArrayList<>(), this.user.getFractions());
    }

    @Test
    void checkGetUserFullName() {
        assertEquals("name familyName", this.user.fullName());
    }

    @Test
    void checkGetUserInitials() {
        assertEquals("n.", this.user.initials());
    }

    @Test
    void checkSetName() {
        this.user.setName("Pablo");
        assertEquals("Pablo", this.user.getName());
    }

    @Test
    void checkSetFamilyName() {
        this.user.setFamilyName("Coronado");
        assertEquals("Coronado", this.user.getFamilyName());
    }

    @Test
    void checkSetFractions() {
        Fraction fraction = new Fraction(1,1);
        ArrayList fractionList = new ArrayList();
        fractionList.add(fraction);
        this.user.setFractions(fractionList);

        assertEquals(fractionList, this.user.getFractions());
    }

    @Test
    void checkAddFraction() {
        Fraction fraction = new Fraction(1,1);
        ArrayList fractionList = new ArrayList();
        fractionList.add(fraction);
        this.user.addFraction(fraction);

        assertEquals(fractionList, this.user.getFractions());
    }

}
