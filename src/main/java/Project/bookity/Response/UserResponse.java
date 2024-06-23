package Project.bookity.Response;


import lombok.Getter;


@Getter
public class UserResponse {
    private String username;
    private String password;
    private String mail;
    public UserResponse(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }
}
