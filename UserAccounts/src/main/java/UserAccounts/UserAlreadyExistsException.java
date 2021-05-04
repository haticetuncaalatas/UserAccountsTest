package UserAccounts;

class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2830932797751670574L;

	UserAlreadyExistsException(Long id) {
		super("User " + id + " already exists!");
	}
}
