package com.trip.trip.service;

import com.trip.trip.entity.User;
import com.trip.trip.payload.authPayload.UserRequestDto;
import com.trip.trip.payload.authPayload.UserResponse;
import com.trip.trip.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public UserService(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequestDto dto) {

        User user = mapToEntity(dto);
        UserResponse response = null;
        Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
        Optional<User> opEmail = userRepository.findByEmail(user.getEmail());
        Optional<User> opMobile = userRepository.findByMobile(user.getMobile());
        if(opUsername.isEmpty() && opMobile.isEmpty() && opEmail.isEmpty())
        {
            user.setRole("ROLE_ADMIN");
            User user1 = userRepository.save(user);
            response = mapToDto(user);

        }

        return response;
    }

    public User mapToEntity(UserRequestDto dto){
        return modelMapper.map(dto,User.class);
    }
    public UserResponse mapToDto(User user)
    {
        return modelMapper.map(user,UserResponse.class);
    }
}
