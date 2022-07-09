package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@ToString
public class UserAuthDetails implements UserDetails {

    private Identification identification;

    private List<Permission> permissionList;

    public UserAuthDetails() {
    }

    public UserAuthDetails(Identification identification, List<Permission> permissionList) {
        this.identification = identification;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
//        return permissionList;
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
