package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Setter
@Getter
@ToString
public class UserAuthDetails implements UserDetails {

    private Identification identification;

    private Set<Permission> permissions;

    public UserAuthDetails() {
    }

    public UserAuthDetails(Identification identification, Set<Permission> permissions) {
        this.identification = identification;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions;
    }

    @Override
    public String getPassword() {
        return identification.getPassword();
    }

    @Override
    public String getUsername() {
        return identification.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
