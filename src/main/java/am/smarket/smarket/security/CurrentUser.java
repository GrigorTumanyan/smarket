package am.smarket.smarket.security;

import am.smarket.smarket.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;


import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User  {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getType().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getId(){
        return user.getId();
    }
}
