package com.example.config;

import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.util.List;

@Provider
@Priority(2)
public class HeaderInterceptor{// implements ContainerRequestFilter {
/*
    private static final Logger log = Logger.getLogger(HeaderInterceptor.class);

    @Context
    UriInfo uriInfo;
    @Override
    public void filter(ContainerRequestContext requestContext) {
        List<String> userTypeList = requestContext.getHeaders().get("X-App-User-Type");
        List<String> userIdList = requestContext.getHeaders().get("X-App-User-Id");
        log.error("Header Interceptor: " + uriInfo.getPath());
        if (userTypeList != null && !userTypeList.isEmpty() && userIdList != null && !userIdList.isEmpty()) {
            String userType = userTypeList.getFirst();
            String userId = userIdList.getFirst();

            requestContext.setProperty("userType", userType);
            requestContext.setProperty("userId", userId);

            log.infof("User Type: %s, User ID: %s", userType, userId);
        }
    }*/
}
