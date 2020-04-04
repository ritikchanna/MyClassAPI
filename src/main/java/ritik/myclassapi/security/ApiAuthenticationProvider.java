package ritik.myclassapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import ritik.myclassapi.UserDetailsServiceImpl;
import ritik.myclassapi.pojo.User;
import ritik.myclassapi.util.Log;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Log.Info(this.getClass().getName(), "Authentication Request from " + username);
        Log.Debug(this.getClass().getName(), "Credentials Username: " + username + " Password: " + password);
        User user = userDetailsService.loadUserByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getPassword().equals(password)) {
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            Log.Info(this.getClass().getName(), "User" + username + " Authenticated");
            Log.Debug(this.getClass().getName(), "User " + username + " is " + user.getRole());
        } else {
            Log.Info(this.getClass().getName(), "User " + username + " Not Authenticated");
        }
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}