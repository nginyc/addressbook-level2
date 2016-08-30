package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {
    public static final String ADDRESS_PARTS_DELIMITER = ",";
    public static final String EXAMPLE = 
    		Block.EXAMPLE + ADDRESS_PARTS_DELIMITER + " " 
    		+ Street.EXAMPLE + ADDRESS_PARTS_DELIMITER + " "
    		+ Unit.EXAMPLE + ADDRESS_PARTS_DELIMITER + " " 
    		+ PostalCode.EXAMPLE;
    		
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "A person's address must be in format: BLOCK, STREET, UNIT, POSTAL_CODE";
    
    // address format is 4 strings delimited by strictly 3 commas
    public static final String ADDRESS_VALIDATION_REGEX = "([.]|[^,])*,([.]|[^,])*,([.]|[^,])*,([.]|[^,])*";

    private static final int ADDRESS_PARTS_COUNT = 4;
    private static final int ADDRESS_PARTS_INDEX_BLOCK = 0;
    private static final int ADDRESS_PARTS_INDEX_STREET = 1;
    private static final int ADDRESS_PARTS_INDEX_UNIT = 2;
    private static final int ADDRESS_PARTS_INDEX_POSTALCODE = 3;
    
    private Block _block; 
    private Street _street;
    private Unit _unit;
    private PostalCode _postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        // Split address string to parts
        String[] addressParts = address.split(ADDRESS_PARTS_DELIMITER);
        _block = new Block(addressParts[ADDRESS_PARTS_INDEX_BLOCK].trim());
        _street = new Street(addressParts[ADDRESS_PARTS_INDEX_STREET].trim());
        _unit = new Unit(addressParts[ADDRESS_PARTS_INDEX_UNIT].trim());
        _postalCode = new PostalCode(addressParts[ADDRESS_PARTS_INDEX_POSTALCODE].trim());
    }

    /**
     * Returns true if a given string is a valid address.
     */
    public static boolean isValidAddress(String address) {
        if (!address.matches(ADDRESS_VALIDATION_REGEX)) {
        	return false; 
        }
        
        // Split address string to parts
        String[] addressParts = address.split(ADDRESS_PARTS_DELIMITER);
        if (addressParts.length != ADDRESS_PARTS_COUNT) {
        	return false;
        }
        
        return Block.isValidBlock(addressParts[ADDRESS_PARTS_INDEX_BLOCK].trim()) 
        		&& Street.isValidStreet(addressParts[ADDRESS_PARTS_INDEX_STREET].trim())
        		&& Unit.isValidUnit(addressParts[ADDRESS_PARTS_INDEX_UNIT].trim())
        		&& PostalCode.isValidPostalCode(addressParts[ADDRESS_PARTS_INDEX_POSTALCODE].trim());
    }

    /**
     * Returns the value of the address as a string
     */
    @Override
    public String toString() {
        return _block.toString() + ADDRESS_PARTS_DELIMITER + " " 
        		+ _street.toString() + ADDRESS_PARTS_DELIMITER + " "
        		+ _unit.toString() + ADDRESS_PARTS_DELIMITER + " " 
        		+ _postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other != this // short circuit if same object
        		|| !(other instanceof Address)) {
        	return false; // instanceof handles nulls
        }
        
        Address otherAddress = (Address)other;
        return (_block.equals(otherAddress._block)
        		&&_street.equals(otherAddress._street)
        		&& _unit.equals(otherAddress._unit)
        		&& _postalCode.equals(otherAddress._postalCode));
    }

    @Override
    public int hashCode() {
        return _block.hashCode() + _street.hashCode() 
        + _unit.hashCode() + _postalCode.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}