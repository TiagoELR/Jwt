package rc.bootsecurity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginUser  {
	
	@NotBlank
	@NotNull
    private String username;
	
	@NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
