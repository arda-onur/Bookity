package com.bookity.project.candidate.arda.onur.persistence.repository;

import com.bookity.project.candidate.arda.onur.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUserId(String userId);
    /*
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity user SET user.isVerified = true WHERE user.VerificationCode=:code")
    void updateVerificationStatus(@Param("code") String code);

    @Query("SELECT user.password FROM UserEntity user WHERE user.username =:username")
    String getPassword(@Param("username") String username);

    @Query("SELECT user.isVerified FROM UserEntity user WHERE user.username =:username")
    boolean isVerified(@Param("username") String username);
     */
}
