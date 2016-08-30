package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address block in the address book.
 */
public class Block {
	public static final String EXAMPLE = "123";
	public static final String MESSAGE_CONSTRAINTS = "A person's address block can be any string";

    public static final String VALIDATION_REGEX = ".*";

	private String _value;
	
	public Block(String block) throws IllegalValueException {
		if (!isValidBlock(block)) {
			throw new IllegalValueException(MESSAGE_CONSTRAINTS);
		}
		
		_value = block;
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
                || (other instanceof Block // instanceof handles nulls
                && _value.equals(((Block) other)._value)); // state check
    }
    
    /**
     * Returns true if a given string is a valid block
     */
    public static boolean isValidBlock(String block) {
        return block.matches(VALIDATION_REGEX);
    }
}
