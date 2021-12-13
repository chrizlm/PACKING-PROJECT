package com.chris.parking_backend.service;

import com.chris.parking_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    MailSendingService mailSendingService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
