package UserAccounts;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

	private final UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}

	// Get all users
	@GetMapping("/users")
	List<User> getAllUserAccounts() {
		return repository.findAll();
	}

	// Get one user
	@GetMapping("/users/{id}")
	User getUserById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	// Add user
	@PostMapping("/users")
	User newUser(@RequestBody User newUser) throws Exception {
		try {

			if (userDataCheck(newUser)) {
				if (!repository.findById(newUser.getId()).isPresent()) {
					return repository.save(newUser);
				} else
					throw new UserAlreadyExistsException(newUser.getId());
			} else
				throw new DataFormatNotValidException();

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	// Update user
	@PutMapping("/users/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) throws Exception {
		try {
			if (userDataCheck(newUser)) {
				if (repository.findById(newUser.getId()).isPresent()) {
					return repository.save(newUser);
				} else
					throw new UserNotFoundException(newUser.getId());
			} else
				throw new DataFormatNotValidException();

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	// Delete user
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) throws Exception {
		try {
			if (repository.findById(id).isPresent()) {
				repository.deleteById(id);
			} else
				throw new UserNotFoundException(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	boolean userDataCheck(User user) {
		if (user.getId() == null)
			return false;
		if (user.getName().isEmpty() || (user.getName() == null) || (user.getName().length() < 3)
				|| (user.getName().length() > 150))
			return false;
		if ((user.getPhone() == null) || (user.getPhone() < 100000000) || (user.getPhone() > 999999999999L))
			return false;
		if (user.getEmail().isEmpty() || (user.getEmail() == null) || user.getEmail().length() > 200)
			return false;
		if (user.getAddress().length() > 200)
			return false;
		if (user.getCountry().isEmpty() || (user.getCountry() == null) || user.getCountry().length() > 56)
			return false;
		if (user.getDepartment().isEmpty() || (user.getDepartment() == null) || user.getDepartment().length() > 50)
			return false;

		return true;
	}
}
