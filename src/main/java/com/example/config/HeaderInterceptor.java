package com.example.config;

import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.util.List;

@Provider
@PreMatching
@Priority(1)
public class HeaderInterceptor implements ContainerRequestFilter {

    private static final Logger log = Logger.getLogger(HeaderInterceptor.class);

    @Context
    UriInfo uriInfo;
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        List<String> userTypeList = requestContext.getHeaders().get("X-App-User-Type");
        List<String> userIdList = requestContext.getHeaders().get("X-App-User-Id");

        if (userTypeList != null && !userTypeList.isEmpty() && userIdList != null && !userIdList.isEmpty()) {
            String userType = userTypeList.get(0);
            String userId = userIdList.get(0);

            requestContext.setProperty("userType", userType);
            requestContext.setProperty("userId", userId);

            log.infof("User Type: %s, User ID: %s", userType, userId);
        }
    }
}
