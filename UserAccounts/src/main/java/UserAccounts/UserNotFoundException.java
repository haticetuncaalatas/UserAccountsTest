package UserAccounts;

class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8542852256002710285L;

	UserNotFoundException(Long id) {
		super("Could not find user " + id);
	}
}
