package com.poype.easyauth.core.service.impl;

import com.poype.easyauth.core.common.util.IdUtil;
import com.poype.easyauth.core.common.util.JwtUtil;
import com.poype.easyauth.core.model.AccessToken;
import com.poype.easyauth.core.model.Identification;
import com.poype.easyauth.core.model.Permission;
import com.poype.easyauth.core.model.UserAuthDetails;
import com.poype.easyauth.core.repository.AccessTokenRepository;
import com.poype.easyauth.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Override
    public String login(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authentication)) {
            // 认证没通过，抛异常
        }

        // Principal对应的就是UserDetailsService.loadUserByUsername方法返回的对象
        UserAuthDetails userAuthDetails = (UserAuthDetails)authentication.getPrincipal();

        Identification identification = userAuthDetails.getIdentification();
        Set<Permission> permissionSet = userAuthDetails.getPermissions();
        List<String> permissionNameList =
                permissionSet.stream().map(Permission::getName).collect(Collectors.toList());
        String tokenValue = IdUtil.generate32Id();

        AccessToken accessToken = AccessToken.builder()
                                            .userId(identification.getUserId())
                                            .accessToken(tokenValue)
                                            .permissions(permissionNameList)
                                            .status(0)
                                            .expiresAt(accessTokenExpireTime())
                                            .build();
        accessTokenRepository.save(accessToken);

        return JwtUtil.createJWT(identification.getUserId(),
                                 permissionNameList,
                                 tokenValue);
    }

    // 第二天凌晨超期
    private Date accessTokenExpireTime() {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        // 日期加1
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
