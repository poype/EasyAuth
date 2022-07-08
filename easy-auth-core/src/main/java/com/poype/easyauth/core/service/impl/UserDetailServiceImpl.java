package com.poype.easyauth.core.service.impl;

import com.poype.easyauth.core.model.Identification;
import com.poype.easyauth.core.repository.IdentificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private IdentificationRepository identificationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Identification identification = identificationRepository.queryByUsername(username);

        System.out.println(identification);

        if (identification == null) {
            throw new UsernameNotFoundException("aaaaaaaaa");
        }

        return null;
    }
}
