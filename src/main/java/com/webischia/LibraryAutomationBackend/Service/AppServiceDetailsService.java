package com.webischia.LibraryAutomationBackend.Service;
import com.webischia.LibraryAutomationBackend.Domains.AccessLevel;
import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppServiceDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public AppServiceDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findByMail(mail);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", mail));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
   /*     user.getAccessLevel().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });*/
        AccessLevel accessLevel = userRepository.getAccessLevel(user.getAccessID());
        authorities.add(new SimpleGrantedAuthority(accessLevel.getAccessDescription()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getMail(), user.getUserPassword(), authorities);

        return userDetails;

    }
}
