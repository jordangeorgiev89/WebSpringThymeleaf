package com.example.demo.service.impl;

import com.example.demo.model.entity.Role;
import com.example.demo.model.service.RoleServiceModel;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        if (this.roleRepository.count() == 0) {
            Role admin = new Role("ADMIN");
            Role user = new Role("USER");

            this.roleRepository.save(admin);
            this.roleRepository.save(user);
        }
    }

    @Override
    public RoleServiceModel findByName(String name) {
        return this.roleRepository
                .findByName(name)
                .map(role -> this.modelMapper.map(role, RoleServiceModel.class))
                .orElse(null);
    }
}
