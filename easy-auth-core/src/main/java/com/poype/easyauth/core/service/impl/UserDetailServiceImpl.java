package com.poype.easyauth.core.service.impl;

import com.poype.easyauth.core.model.Identification;
import com.poype.easyauth.core.model.Role;
import com.poype.easyauth.core.model.UserAuthDetails;
import com.poype.easyauth.core.repository.IdentificationRepository;
import com.poype.easyauth.core.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IdentificationRepository identificationRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Identification identification = identificationRepository.queryByUsername(username);

        if (identification == null) {
            log.warn("username {} not found", username);
            throw new UsernameNotFoundException("username not found");
        }

        log.info("username {} login at {}", username, new Date());

        List<Role> roleList = roleRepository.queryRoleListByUserId(identification.getUserId());

        log.info("roleList: {}", roleList);

        return new UserAuthDetails(identification, null);
    }
}
