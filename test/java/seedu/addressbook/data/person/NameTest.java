package seedu.addressbook.data.person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    private Name name;
    
    @Before
    public void before() {
        try {
            name = new Name("Fish Ball Nuggets");
        } catch (IllegalValueException e) {
           fail("initialization of names failed");
        }
    }
    
    @Test
    public void isSimilar_otherNull_false() {
        assertFalse(name.isSimilar(null));
    }
    
    @Test
    public void isSimilar_sameNameInstance_true() {
        assertTrue(name.isSimilar(name));
    }
    
    @Test
    public void isSimilar_clonedName_true() throws IllegalValueException {
        assertTrue(name.isSimilar(new Name(name.fullName)));
    }
    
    @Test
    public void isSimilar_otherIsSubstring_false() throws IllegalValueException {
        assertTrue(name.fullName.length() >= 1);
        assertFalse(name.isSimilar(new Name(name.fullName.substring(1))));
        assertFalse(name.isSimilar(new Name(name.fullName.substring(0, name.fullName.length() - 1))));
    }
    
    @Test
    public void isSimilar_otherIsSuperstring_false() throws IllegalValueException {
        assertFalse(name.isSimilar(new Name(name.fullName + " A")));
        assertFalse(name.isSimilar(new Name("NOOB " + name.fullName)));
    }
    
    @Test
    public void isSimilar_differentCases_true() throws IllegalValueException {
        assertTrue(name.isSimilar(new Name(name.fullName.toLowerCase())));
        assertTrue(name.isSimilar(new Name(name.fullName.toUpperCase())));
        assertTrue(name.isSimilar(new Name("fisH BaLL nuGGets")));
    }
    
    @Test
    public void isSimilar_wrongSpaces_false() throws IllegalValueException {
        assertFalse(name.isSimilar(new Name("FishBallNuggets")));
        assertFalse(name.isSimilar(new Name("FishBall Nuggets")));
        assertFalse(name.isSimilar(new Name("Fish Bal lNuggets")));
        assertFalse(name.isSimilar(new Name("Fish Bal l Nuggets")));
    }
    
    @Test
    public void isSimilar_extraSpaces_true() throws IllegalValueException {
        assertTrue(name.isSimilar(new Name("Fish  Ball  Nuggets")));
        assertTrue(name.isSimilar(new Name(" Fish Ball Nuggets ")));
        assertTrue(name.isSimilar(new Name("Fish                Ball Nuggets")));
    }
    
    @Test
    public void isSimilar_differentOrder_true() throws IllegalValueException {
        assertTrue(name.isSimilar(new Name("Nuggets Fish Ball")));
        assertTrue(name.isSimilar(new Name("Fish Nuggets Ball")));
    }
    
    @Test
    public void isSimilar_extraSpacesAndDifferentOrderAndDifferentCases_true() throws IllegalValueException {
        assertTrue(name.isSimilar(new Name("Nuggets Fish ball ")));
        assertTrue(name.isSimilar(new Name("Fish  NuggetS bAll")));
        assertTrue(name.isSimilar(new Name("NUggetS bAll        FISH  ")));
    }
    
    @Test
    public void isSimilar_extraWords_false() throws IllegalValueException {
        assertFalse(name.isSimilar(new Name("Fish Ball Nuggets A")));
        assertFalse(name.isSimilar(new Name("Some Fish Ball Nuggets")));
        assertFalse(name.isSimilar(new Name("Fish Ball Green Nuggets")));
    }
}
