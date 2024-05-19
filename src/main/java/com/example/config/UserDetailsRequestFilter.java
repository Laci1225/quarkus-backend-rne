package com.example.config;

import com.example.constants.AppMetadata;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

@Provider
@Priority(1)
@ApplicationScoped
public class UserDetailsRequestFilter implements ContainerRequestFilter {

    @Inject
    Auth0Service auth0Service;

    @Inject
    SecurityIdentity securityIdentity;


    private static final Logger log = Logger.getLogger(UserDetailsRequestFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (securityIdentity.isAnonymous()) {
            return;
        }
        String auth0UserId = securityIdentity.getPrincipal().getName();
        log.error("Authentication: " + auth0UserId);
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
