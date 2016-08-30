package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address unit in the address book.
 */
public class Unit {
	public static final String EXAMPLE = "#12-34";
	public static final String MESSAGE_CONSTRAINTS = "A person's address unit can be any string";

    public static final String VALIDATION_REGEX = ".*";

	private String _value;
	
	public Unit(String unit) throws IllegalValueException {
		if (!isValidUnit(unit)) {
			throw new IllegalValueException(MESSAGE_CONSTRAINTS);
		}
		
		_value = unit;
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
                || (other instanceof Unit // instanceof handles nulls
                && _value.equals(((Unit) other)._value)); // state check
    }
    
    /**
     * Returns true if a given string is a valid unit
     */
    public static boolean isValidUnit(String unit) {
        return unit.matches(VALIDATION_REGEX);
    }
}
