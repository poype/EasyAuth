package com.poype.easyauth.core.common.filter;

import com.poype.easyauth.core.common.dto.JwtParseDto;
import com.poype.easyauth.core.common.util.JwtUtil;
import com.poype.easyauth.core.model.Permission;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CheckAuthenticationFilter extends OncePerRequestFilter {

    private final String LOGIN_PAGE_PATH = "/login";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String jwtStr = request.getHeader("Authentication");
        if (StringUtils.isEmpty(jwtStr)) {
            if (request.getRequestURI().equals(LOGIN_PAGE_PATH)) {
                // 登录页面，直接放行，交由后面的Filter处理
                filterChain.doFilter(request, response);
            } else {
                // 用户未登录，redirect到login页面
                redirectToLoginPage(response);
            }
            return;
        }

        JwtParseDto parseResult = JwtUtil.parseJWT(jwtStr);
        log.info("parseResult: {}", parseResult);

        if (parseResult.isExpire()) {
            // todo jwt超期，需要刷新
        }

        List<Permission> permissionList = parseResult.getPermissionNames()
                                                     .stream()
                                                     .map(Permission::new)
                                                     .collect(Collectors.toList());

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(parseResult.getUserId(), null, permissionList);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }

    private void redirectToLoginPage(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.sendRedirect(LOGIN_PAGE_PATH);
    }
}
