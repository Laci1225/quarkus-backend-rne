package com.example.config;

import io.quarkus.oidc.OidcTenantConfig;
import io.quarkus.oidc.runtime.OidcProvider;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class SecurityConfig {

    @ConfigProperty(name = "quarkus.oidc.auth-server-url")
    String authServerUrl;

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String clientId;

    @ConfigProperty(name = "quarkus.oidc.credentials.secret")
    String clientSecret;

    @Inject
    CustomTenantConfigResolver tenantConfigResolver;

    void onStart(@Observes StartupEvent ev) {
        OidcTenantConfig oidcTenantConfig = new OidcTenantConfig();
        oidcTenantConfig.setAuthServerUrl(authServerUrl);
        oidcTenantConfig.setClientId(clientId);
        oidcTenantConfig.setCredentials(new OidcTenantConfig.Credentials());
        oidcTenantConfig.getCredentials().setSecret(clientSecret);
        tenantConfigResolver.addTenant("default", oidcTenantConfig);
    }
}


