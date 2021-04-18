package com.github.jeffreymzd.redi2read.boot;

import com.github.jeffreymzd.redi2read.models.Role;
import com.github.jeffreymzd.redi2read.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CreateRoles implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info(">>>> Run from the CreateRoles CommandLineRunner...");
        roleRepository.deleteAll();
        if (roleRepository.count() == 0) {
            Role adminRole = Role.builder().name("admin").build();
            Role customerRole = Role.builder().name("customer").build();
            Role superuserRole = Role.builder().name("superuser").build();
            roleRepository.save(adminRole);
            roleRepository.save(customerRole);
            roleRepository.save(superuserRole);
            log.info(">>>> Created admin and customer roles ...");
        }
    }
}
