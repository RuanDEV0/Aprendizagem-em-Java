package academy.devdojo.springbootessentials.service;

import academy.devdojo.springbootessentials.repository.DevDojoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevDojoUserDetailsService implements UserDetailsService {
    private final DevDojoUserRepository devDojoUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username)   {
        return Optional.ofNullable(devDojoUserRepository.findByUserName(username))
                .orElseThrow(() -> new UsernameNotFoundException("devdojo User not found"));
    }
}
