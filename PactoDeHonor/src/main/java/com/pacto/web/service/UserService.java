package com.pacto.web.service;

import com.pacto.web.repository.RoleRepository;
import com.pacto.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pacto.web.model.Role;
import com.pacto.web.model.User;
import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
       this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public User saveUser(User user) {

        Role userRole = roleRepository.findByRole("PSICOLOGO");
        user.setPasswordN(user.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }
    /*
    public User findUserbyUsuario (String Usuario){
        return userRepository.findByUsuario(String usuario);
    }

*/


}