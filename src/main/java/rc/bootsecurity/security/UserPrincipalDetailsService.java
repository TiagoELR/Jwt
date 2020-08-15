package rc.bootsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rc.bootsecurity.model.User;
import rc.bootsecurity.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
       if(user == null) {
    	   throw new UsernameNotFoundException("Usuário não cadastrado");
       }
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }
}
