package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.exception.UserAlreadyExistsException;
import com.bookity.project.candidate.arda.onur.exception.UserNotFoundException;
import com.bookity.project.candidate.arda.onur.persistence.model.User;
import com.bookity.project.candidate.arda.onur.persistence.repository.UserRepository;
import com.bookity.project.candidate.arda.onur.utility.ArgumentPreconditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserCrudService {
    private final UserRepository userRepository;

    public User getUserByUserId(String userId) {
        ArgumentPreconditions.requireNotBlank("Argument 'userId' can not be blank!", userId);
        log.info("Getting a user with userId ({}).", userId);

        return this.userRepository.findUserByUserId(userId)
            .orElseThrow(() -> new UserNotFoundException("user.not.found.message", userId));
    }

    public User createUser(User newUser) {
        Objects.requireNonNull(newUser, "Argument 'newUser' can not be null!");
        log.info("Creating new user with email ({}).", newUser.getEmail());

        this.userRepository.findUserByEmail(newUser.getEmail())
            .ifPresent(user -> {
                throw new UserAlreadyExistsException("user.already.exists.message", user.getEmail());
            });

        return this.userRepository.save(newUser);
    }

    public void deleteUserByUserId(String userId) {
        ArgumentPreconditions.requireNotBlank("Argument 'userId' can not be blank!", userId);

        log.info("Deleting a user with userId ({}).", userId);
        this.userRepository.delete(getUserByUserId(userId));
    }

    public User updateUser(User userToBeUpdated) {
        Objects.requireNonNull(userToBeUpdated, "Argument 'userToBeUpdated' can not be null!");
        log.info("Updating a user with userId ({}).", userToBeUpdated.getUserId());
        return this.userRepository.save(userToBeUpdated);
    }
}
