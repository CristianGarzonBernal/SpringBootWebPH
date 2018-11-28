package com.pacto.web.service;

import com.pacto.web.model.Misiones;
import com.pacto.web.model.Role;
import com.pacto.web.model.User;
import com.pacto.web.repository.MisionesRepository;
import com.pacto.web.repository.RoleRepository;
import com.pacto.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("misionesService")
public class MisionesService {
    private MisionesRepository misionesRepository;

    @Autowired
    public MisionesService(MisionesRepository misionesRepository) {

        this.misionesRepository = misionesRepository;
    }

    public Collection<Misiones> findByAutor(String autor){
        return misionesRepository.findMisionesByAutor(autor);
    }

    public Collection<Map> findMisionesByIds(Integer [] array){
        return misionesRepository.findMisionesByIds(array);
    }

}