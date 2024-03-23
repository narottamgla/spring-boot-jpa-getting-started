package com.demo.serviceimpl;

import com.demo.dto.UserDTO;
import com.demo.exception.ResourceNotFoundException;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userDB = this.userRepository.findById(user.getId());
        if(userDB.isPresent()){
            User userUpdate = userDB.get();
            userUpdate.setId(user.getId());
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setFirstName(user.getLastName());
            userUpdate.setFirstName(user.getLastName());
            return userRepository.save(userUpdate);

        }else {
            throw  new ResourceNotFoundException("No Record found with ID:"+ user.getId());
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getUserList() {
     return userRepository.findAll();
    }

    @Override
    public UserDTO getUserDetailsById(Long id) {
        Optional<User> userDB = this.userRepository.findById(id);
        if(userDB.isPresent()){
            return modelMapper.map(userDB, UserDTO.class);
        }else {
            throw new ResourceNotFoundException("User Not found with ID: "+ id);
        }
    }
}
