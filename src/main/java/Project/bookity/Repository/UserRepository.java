package Project.bookity.Repository;

import Project.bookity.Entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
 public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity user SET user.isVerified = true WHERE user.VerificationCode=:code")
    void updateVerificationStatus(@Param("code") String code);
    @Query("SELECT user.password FROM UserEntity user WHERE user.username =:username")
    String getPassword(@Param("username") String username);
    @Query("SELECT user.isVerified FROM UserEntity user WHERE user.username =:username")
    boolean isVerified(@Param("username") String username);
}
