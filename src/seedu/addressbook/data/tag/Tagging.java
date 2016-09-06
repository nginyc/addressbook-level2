package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents a tagging/untagging action done on a person
 */
public class Tagging {
    public enum MODE {
        ADD, DELETE
    }

    private final Person personTagged;
    private final Tag tag;
    private final MODE mode;

    public Tagging(Person personTagged, Tag tag, MODE mode) {
        this.personTagged = personTagged;
        this.tag = tag;
        this.mode = mode;
    }

    public Tag getTag() {
        return tag;
    }

    public Person getPersonTagged() {
        return personTagged;
    }

    public MODE getMode() {
        return mode;
    }

    @Override
    public String toString() {
        String prefix = "";

        switch (mode) {
        case ADD: 
            prefix = "+"; 
            break;
        case DELETE: 
            prefix = "-"; 
            break;
        }

        return prefix + " " + personTagged.getName().toString() + " " + tag.toString();
    }
}
