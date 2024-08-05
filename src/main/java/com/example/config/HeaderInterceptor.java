package com.example.config;

/*
@Provider
@Priority(2)
public class HeaderInterceptor implements ContainerRequestFilter {

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
    }
}*/
