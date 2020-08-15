package rc.bootsecurity.dbInit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rc.bootsecurity.model.User;
import rc.bootsecurity.repository.UserRepository;

@Service
public class DbInit implements CommandLineRunner {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) {
		// Delete all
		this.userRepository.deleteAll();

		// Crete users
		User user = new User("tiago", passwordEncoder.encode("tiago"), "USER", "");
		User admin = new User("admin", passwordEncoder.encode("admin"), "ADMIN", "");

		List<User> users = Arrays.asList(user, admin);

		// Save to db
		this.userRepository.saveAll(users);
	}
}
