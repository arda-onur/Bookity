package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.persistence.dto.UserDto;
import com.bookity.project.candidate.arda.onur.persistence.mapper.UserMapper;
import com.bookity.project.candidate.arda.onur.persistence.model.User;
import com.bookity.project.candidate.arda.onur.service.UserCrudService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserCrudRestController {
    private final UserCrudService userCrudService;
    private final UserMapper userMapper;

    @PostMapping
    ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(
            this.userMapper.map(this.userCrudService.createUser(this.userMapper.map(createUserRequest))));
    }

    @GetMapping("{userId}")
    ResponseEntity<UserDto> getUserByUserId(
        @NotBlank(message = "userId.not.blank.message")
        @PathVariable("userId") @Size(min = 36, max = 36, message = "userId.length.message>") String userId) {
        return ResponseEntity.ok(this.userMapper.map(this.userCrudService.getUserByUserId(userId)));
    }

    @DeleteMapping("{userId}")
    ResponseEntity<Void> deleteUserByUserId(
        @NotBlank(message = "userId.not.blank.message")
        @PathVariable("userId") @Size(min = 36, max = 36, message = "userId.length.message") String userId) {
        this.userCrudService.deleteUserByUserId(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{userId}")
    ResponseEntity<UserDto> updateUserByUserId(
        @NotBlank(message = "userId.not.blank.message")
        @PathVariable("userId") @Size(min = 36, max = 36, message = "userId.length.message") String userId,
        @Valid @RequestBody UpdateUserRequest updateUserRequest) {
        User userToBeUpdated = this.userCrudService.getUserByUserId(userId);
        userToBeUpdated = this.userMapper.update(userToBeUpdated, updateUserRequest);
        userToBeUpdated = this.userCrudService.updateUser(userToBeUpdated);
        return ResponseEntity.ok(this.userMapper.map(userToBeUpdated));
    }
}
