package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.user.UserCreateDTO;
import com.marcelosarinho.moviereview.dto.user.UserDTO;
import com.marcelosarinho.moviereview.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUserEntity(UserCreateDTO userDTO);
    List<UserDTO> toUserDTOList(List<User> users);
}
