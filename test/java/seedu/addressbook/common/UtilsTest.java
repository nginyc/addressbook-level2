package seedu.addressbook.common;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class UtilsTest {
	private static Object nullObj = null;
	private static Tag tag1;
	private static Tag tag1Clone;
	private static Tag tag2;
	
	@Before
	public void setup() {
		tag1 = generateTag("A");
		tag1Clone = generateTag("A");
		tag2 = generateTag("B");
	}
	
	@Test
    public void isAnyNull_emptyInput_returnsFalse() {
    	assertFalse(Utils.isAnyNull());
    }
    
    @Test
    public void isAnyNull_multipleNulls_returnsTrue() {
    	assertTrue(Utils.isAnyNull(nullObj));
    	assertTrue(Utils.isAnyNull(nullObj, nullObj));
    	assertTrue(Utils.isAnyNull(nullObj, nullObj, nullObj));
    	assertTrue(Utils.isAnyNull(nullObj, nullObj, nullObj, nullObj));
    	assertTrue(Utils.isAnyNull(nullObj, nullObj, nullObj, nullObj, nullObj));
    }
    
    @Test
    public void isAnyNull_noNulls_returnsFalse() {
    	ArrayList<String> emptyList = new ArrayList<String>();
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("NOT NULL");
    	list.add("REALLY NOT NULL");
    	
    	assertFalse(Utils.isAnyNull(new Object()));
    	assertFalse(Utils.isAnyNull(new Object(), new Object(), new Object()));
    	assertFalse(Utils.isAnyNull(emptyList));
    	assertFalse(Utils.isAnyNull(""));
    	assertFalse(Utils.isAnyNull(list, emptyList));
    	assertFalse(Utils.isAnyNull(list, emptyList, "SUPER NOT NULL"));
    }
    
    @Test
    public void isAnyNull_mixedNulls_returnsTrue() {
    	ArrayList<String> emptyList = new ArrayList<String>();
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("NOT NULL");
    	list.add("REALLY NOT NULL");
    	
    	assertTrue(Utils.isAnyNull(nullObj, ""));
    	assertTrue(Utils.isAnyNull("", nullObj, ""));
    	assertTrue(Utils.isAnyNull(emptyList, list, nullObj));
    	assertTrue(Utils.isAnyNull(new Object(), new Object(), nullObj, new Object()));
    	assertTrue(Utils.isAnyNull(list, list, nullObj, nullObj, "VERY NOT NULL"));
    }
    
    @Test
    public void elementsAreUnique_emptyInput_returnsTrue() {
    	assertTrue(Utils.elementsAreUnique(new ArrayList<>()));
    }
    
    @Test
    public void elementsAreUnique_singleInput_returnsTrue() {
    	assertTrue(Utils.elementsAreUnique(new ArrayList<String>() {{
    		add("LOL");
    	}}));
    	assertTrue(Utils.elementsAreUnique(new ArrayList<Tag>() {{
    		add(tag1);
    	}}));
    	assertTrue(Utils.elementsAreUnique(new ArrayList<Object>() {{
    		add(nullObj);
    	}}));
    }
    
    @Test
    public void elementsAreUnique_allSameStrings_returnsFalse() {
    	assertFalse(Utils.elementsAreUnique(new ArrayList<String>() {{
    		add("A");
    		add("A");
    	}}));
    	assertFalse(Utils.elementsAreUnique(new ArrayList<String>() {{
    		add("A");
    		add("A");
    		add("A");
    		add("A");
    	}}));
    }
    
    @Test
    public void elementsAreUnique_allNulls_returnsFalse() {
    	assertFalse(Utils.elementsAreUnique(new ArrayList<Object>() {{
    		add(nullObj);
    		add(nullObj);
    	}}));
    	assertFalse(Utils.elementsAreUnique(new ArrayList<Object>() {{
    		add(nullObj);
    		add(nullObj);
    		add(nullObj);
    		add(nullObj);
    	}}));
    }
    
    @Test
    public void elementsAreUnique_hasSameTags_returnsFalse() {
    	// Check shallow comparisons
    	assertFalse(Utils.elementsAreUnique(new ArrayList<Tag>() {{
    		add(tag1);
    		add(tag1);
    	}}));
    	
    	assertFalse(Utils.elementsAreUnique(new ArrayList<Tag>() {{
    		add(tag1);
    		add(tag2);
    		add(tag2);
    	}}));

    	// Check deep comparisons
    	assertFalse(Utils.elementsAreUnique(new ArrayList<Tag>() {{
    		add(tag1);
    		add(tag1Clone);
    		add(tag2);
    	}}));
    }
    
    @Test
    public void elementsAreUnique_differentTags_returnsTrue() {
    	assertTrue(Utils.elementsAreUnique(new ArrayList<Tag>() {{
    		add(tag1);
    		add(tag2);
    	}}));
    	
    	assertTrue(Utils.elementsAreUnique(new ArrayList<Tag>() {{
    		add(tag1);
    		add(tag2);
    		add(null);
    	}}));
    }
    
    private static Tag generateTag(String suffix) {
        try {
			return new Tag("tag" + suffix);
		} catch (IllegalValueException e) {
            throw new RuntimeException("test tag data should be valid by definition", e);
		}
    }
}
