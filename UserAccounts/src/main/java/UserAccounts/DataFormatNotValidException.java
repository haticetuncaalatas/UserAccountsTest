package UserAccounts;

class DataFormatNotValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1504022435901285989L;

	DataFormatNotValidException() {
		super("Given data format is not valid");
	}
}
