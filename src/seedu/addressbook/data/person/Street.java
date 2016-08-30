package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address street in the address book.
 */
public class Street {
	public static final String EXAMPLE = "Clementi Ave 3";
	public static final String MESSAGE_CONSTRAINTS = "A person's address street can be any string";

    public static final String VALIDATION_REGEX = ".*";

	private String _value;
	
	public Street(String street) throws IllegalValueException {
		if (!isValidStreet(street)) {
			throw new IllegalValueException(MESSAGE_CONSTRAINTS);
		}
		
		_value = street;
	}

	@Override
	public int hashCode() {
		return _value.hashCode();
	}

	@Override
	public String toString() {
		return _value.toString();
	}
	
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && _value.equals(((Street) other)._value)); // state check
    }
    
    /**
     * Returns true if a given string is a valid block
     */
    public static boolean isValidStreet(String street) {
        return street.matches(VALIDATION_REGEX);
    }
}
