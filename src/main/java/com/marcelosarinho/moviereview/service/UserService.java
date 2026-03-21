package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.dto.user.UserDTO;
import com.marcelosarinho.moviereview.entity.User;
import com.marcelosarinho.moviereview.mapper.UserMapper;
import com.marcelosarinho.moviereview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper mapper;

    public List<UserDTO> findAll() {
        return mapper.toUserDTOList(repository.findAll());
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User insert(User obj) {
        obj.setPassword(passwordEncoder.encode(obj.getPassword()));

        return repository.save(obj);
    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
    }
}
