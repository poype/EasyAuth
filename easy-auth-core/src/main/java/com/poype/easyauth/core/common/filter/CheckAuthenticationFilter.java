package com.poype.easyauth.core.common.filter;

import com.poype.easyauth.core.common.util.Constant;
import com.poype.easyauth.core.common.util.JwtUtil;
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
import java.util.Map;

@Component
public class CheckAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String jwtStr = request.getHeader("Authentication");
        if (StringUtils.isEmpty(jwtStr)) {
            // 直接放行，交由后面的Filter处理
            filterChain.doFilter(request, response);
            return;
        }

        Map<String, String> parseResultMap = JwtUtil.parseJWT(jwtStr);
        System.out.println(parseResultMap);
        if (parseResultMap.get(JwtUtil.isJwtExpire).equals(Constant.TRUE_STR)) {
            // todo jwt超期，需要刷新
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(parseResultMap.get(JwtUtil.userIdKey), null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
