package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address postal code in the address book.
 */
public class PostalCode {
	public static final String EXAMPLE = "231534";
	public static final String MESSAGE_CONSTRAINTS = "A person's address postal code can be any string";

    public static final String VALIDATION_REGEX = ".*";

	private String _value;
	
	public PostalCode(String postalCode) throws IllegalValueException {
		if (!isValidPostalCode(postalCode)) {
			throw new IllegalValueException(MESSAGE_CONSTRAINTS);
		}
		
		_value = postalCode;
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
                || (other instanceof PostalCode // instanceof handles nulls
                && _value.equals(((PostalCode) other)._value)); // state check
    }
    
    /**
     * Returns true if a given string is a valid postal code
     */
    public static boolean isValidPostalCode(String postalCode) {
        return postalCode.matches(VALIDATION_REGEX);
    }
}
