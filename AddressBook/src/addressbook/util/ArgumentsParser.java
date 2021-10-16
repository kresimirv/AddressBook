package addressbook.util;

/**
 * ArgumentsParser - class for parsing program input arguments
 *
 */
public final class ArgumentsParser {

	private String[] args;
	
	public ArgumentsParser(String[] args) {
		this.args = args;
	}
	
	/**
	 * Get value for input argument key
	 * 
	 * @param key Input argument key
	 * @return Value of input argument
	 */
	public String ValueForKey(String key) {
		int index = this.FindIndexInArray(args, key);
		if((index + 1) >= args.length) {
			return null;
		}
		
		String value = (index == -1 ? null : args[index+1] );
		return value;
	}
	
	/**
	 * Check if key exists as input argument
	 * @param key Input argument key
	 * @return True if input key exists otherwise false
	 */
	public boolean KeyExists(String key) {
		return FindIndexInArray(args, key) != -1 ? true : false;
	}
	
	
	private int FindIndexInArray(String[] array, String key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i].equalsIgnoreCase(key)) {
				return i;
			}
		}
		
		return -1;
	}

}
