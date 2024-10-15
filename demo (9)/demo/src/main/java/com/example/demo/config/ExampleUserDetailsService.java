package com.example.demo.config;

import com.example.demo.model.CustomerBE;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerBE customerBE = customerRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User \"" + username + "\"not found")
        );
        List<SimpleGrantedAuthority> authorities =customerBE.getAuthorities().stream().map(
                authority -> new SimpleGrantedAuthority(authority.getNAME())
        ).toList();

        return new User(customerBE.getEmail(), customerBE.getPassword(), authorities);
    }
}
