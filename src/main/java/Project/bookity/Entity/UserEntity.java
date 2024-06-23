package Project.bookity.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity {
    @Id
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String mail;
    @Column
    private String VerificationCode;
    @Column
    boolean isVerified;
}
