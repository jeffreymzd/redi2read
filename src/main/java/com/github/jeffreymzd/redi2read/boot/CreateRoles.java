package com.github.jeffreymzd.redi2read.boot;

import com.github.jeffreymzd.redi2read.models.Role;
import com.github.jeffreymzd.redi2read.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by jeffreymzd on 4/13/21
 * Run on each server start-up or on each live reload
 */
@Component
@Order(1) // takes a numeric value indicating the order of execution
@Slf4j
public class CreateRoles implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> Run from the CreateRoles CommandLineRunner...");
        if (roleRepository.count() == 0) {
            Role adminRole = Role.builder().name("admin").build();
            Role customerRole = Role.builder().name("customer").build();
            roleRepository.save(adminRole);
            roleRepository.save(customerRole);
            log.info(">>>> Created admin and customer roles ...");
        }
    }
}
