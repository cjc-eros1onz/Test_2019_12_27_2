package com.czxy.filter;

import com.czxy.domain.User;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    private static final String pubKeyPath = "D:\\ras\\ras.pub";
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();
        if ("/api/examcustomer/user/login".equals(requestURI)){
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("authorization");
        try {
            JwtUtils.getObjectFromToken(token, RasUtils.getPublicKey(pubKeyPath), User.class);
        } catch (Exception e) {
            e.printStackTrace();
            requestContext.setResponseStatusCode(403);
            requestContext.setSendZuulResponse(false);
        }
        return null;
    }
}
