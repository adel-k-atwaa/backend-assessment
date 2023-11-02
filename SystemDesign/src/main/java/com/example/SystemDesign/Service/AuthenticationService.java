package com.example.SystemDesign.Service;

import com.example.SystemDesign.Config.JwtService;
import com.example.SystemDesign.Domain.Token;
import com.example.SystemDesign.Domain.User;
import com.example.SystemDesign.Repository.UserRepository;
import com.example.SystemDesign.Service.DTO.UserDTO;
import com.example.SystemDesign.Service.Mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
    }

    public UserDTO register(UserDTO userDTO){
        User user = userMapper.toEntty(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return  userMapper.toDto(user);
    }

    public Token authenticate(UserDTO userDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getEmail(),userDTO.getPassword()));
        var user=userRepository.findByEmail(userDTO.getEmail()).orElseThrow();
        return jwtService.generateToken(user);
    }
}
