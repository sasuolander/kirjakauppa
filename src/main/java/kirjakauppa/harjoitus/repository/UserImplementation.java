package kirjakauppa.harjoitus.repository;

import kirjakauppa.harjoitus.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserImplementation implements UserDetailsService {

    private final UserRepository rep;

    @Autowired
    public UserImplementation(UserRepository userRepository) {
        this.rep= userRepository; }

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException{
        User curruser = rep.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,
                curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}