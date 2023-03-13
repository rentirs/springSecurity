package com.rentirs.security.services;

import com.rentirs.security.models.Person;
import com.rentirs.security.repositories.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register (Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }
}
