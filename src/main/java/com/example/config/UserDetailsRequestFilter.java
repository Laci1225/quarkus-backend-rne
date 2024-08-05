package com.example.config;

/*
@Provider
@Priority(1)
@PreMatching
@ApplicationScoped
public class UserDetailsRequestFilter implements ContainerRequestFilter {

    @Inject
    Auth0Service auth0Service;

    @Inject
    SecurityIdentity securityIdentity;


    private static final Logger log = LoggerFactory.getLogger(UserDetailsRequestFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) {
        if (securityIdentity.isAnonymous()) {
            return;
        }
        String auth0UserId = securityIdentity.getPrincipal().getName();
        CompletionStage<AppMetadata> appMetadataStage = auth0Service.getUserInfo(auth0UserId).subscribeAsCompletionStage();
        appMetadataStage.whenComplete((appMetadata, throwable) -> {
            if (throwable != null) {
                log.error("Failed to get user info from Auth0", throwable);
                return;
            }

            String userType = appMetadata.appUserType();
            String userId = appMetadata.appUserId();

            requestContext.getHeaders().add("X-App-User-Type", userType);
            requestContext.getHeaders().add("X-App-User-Id", userId);
        });
    }
}
*/