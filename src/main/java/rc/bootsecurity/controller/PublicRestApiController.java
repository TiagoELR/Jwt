package rc.bootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import rc.bootsecurity.model.User;
import rc.bootsecurity.repository.UserRepository;

@RestControllerAdvice
@RestController
@RequestMapping("/api/public")
@CrossOrigin
public class PublicRestApiController {
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/user/")
    public String test1(){
        return "API Test";
    }

    @GetMapping("/admin/users/")
    public List<User> users(){
        return this.userRepository.findAll();
    }
    @PostMapping("/admin/user/add")
    public String addUsers(@RequestBody User user){
    
		user.setPassword(passwordEncoder.encode(user.getPassword()));
    	this.userRepository.save(user);
        return "Usuário adicionado com sucésso!";
    }
}
