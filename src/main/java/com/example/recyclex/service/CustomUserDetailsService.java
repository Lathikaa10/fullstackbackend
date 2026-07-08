package com.example.recyclex.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.recyclex.entity.SystemUser;
import com.example.recyclex.repository.SystemUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

        @Autowired
        private SystemUserRepository repo;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                // DB-la irundhu List-ah edukkum
                List<SystemUser> users = repo.findByEmail(email);

                if (users == null || users.isEmpty()) {
                        throw new UsernameNotFoundException("User Not Found: " + email);
                }

                // Duplicate irundhalum mudhal record-ai mattum eduthukkum (Crash aagathu)
                SystemUser user = users.get(0);

                return new org.springframework.security.core.userdetails.User(
                                user.getEmail(),
                                user.getPassword(),
                                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
        }
}