package seedu.addressbook.ui;

import java.io.PrintStream;
import java.util.List;

/**
 * Does all formatting and styling of output text for the application.
 */

public class Formatter {

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final PrintStream _out;
    
    public Formatter(PrintStream out) {
    	_out = out;
    }
    
    public void print(String string) {
    	_out.print(LINE_PREFIX + string.replace("\n", LS + LINE_PREFIX));
    }
    
    public void printBlankLine() {
    	printLines("");
    }

	public void printLines(String... strings) {
		for (String string : strings) {
			print(string);
			_out.println();
		}
	}
	
	public void printDivider() {
		printDivider(1);
	}
	
	public void printDivider(int height) {
		for (int i = 0; i < height; i ++) {
			printLines(DIVIDER);
		}
	}
	
	 /** Formats a list of strings as a viewable indexed list. */
    /** Shows a list of strings to the user, formatted as an indexed list. */
    public void printIndexedList(List<String> listItems) {
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
        	printLines(getIndexedListItem(displayIndex, listItem));
            displayIndex++;
        }
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
