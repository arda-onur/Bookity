package com.bookity.project.candidate.arda.onur.mapper;

import com.bookity.project.candidate.arda.onur.controller.CreateUserRequest;
import com.bookity.project.candidate.arda.onur.controller.UpdateUserRequest;
import com.bookity.project.candidate.arda.onur.dto.UserDto;
import com.bookity.project.candidate.arda.onur.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "enabled", constant = "false")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    User map(CreateUserRequest createUserRequest);

    UserDto map(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "password", ignore = true)
    User map(UpdateUserRequest updateUserRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    User update(@MappingTarget User userToBeUpdated, UpdateUserRequest updateUserRequest);
}
