package com.example.config;

import io.quarkus.oidc.OidcRequestContext;
import io.quarkus.oidc.OidcTenantConfig;
import io.quarkus.oidc.TenantConfigResolver;
import io.quarkus.oidc.TenantResolver;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

@ApplicationScoped
public class SecurityConfig{// implements TenantConfigResolver {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
    @ConfigProperty(name = "quarkus.oidc.auth-server-url")
    String authServerUrl;

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String clientId;

    @ConfigProperty(name = "quarkus.oidc.credentials.secret")
    String clientSecret;


    //@Inject
    //CustomTenantConfigResolver tenantConfigResolver;

    /*void onStart(@Observes StartupEvent ev) {
        OidcTenantConfig oidcTenantConfig = new OidcTenantConfig();
        oidcTenantConfig.setAuthServerUrl(authServerUrl);
        oidcTenantConfig.setClientId(clientId);
        oidcTenantConfig.setCredentials(new OidcTenantConfig.Credentials());
        oidcTenantConfig.getCredentials().setSecret(clientSecret);
        oidcTenantConfig.getToken().setAudience(Collections.singletonList("http://bc/api"));
        resolver.resolve(null);
        //tenantConfigResolver.addTenant("default", oidcTenantConfig);
    }*/
/*
    @Override
    public Uni<OidcTenantConfig> resolve(RoutingContext routingContext, OidcRequestContext<OidcTenantConfig> requestContext) {
        String path = routingContext.request().path();
        log.error("Path: {}", path);
        OidcTenantConfig oidcTenantConfig = new OidcTenantConfig();
        oidcTenantConfig.setTenantId("dev-wnuf5ensk4dnqucn");
        oidcTenantConfig.setAuthServerUrl(authServerUrl);
        oidcTenantConfig.setClientId(clientId);
        oidcTenantConfig.setCredentials(new OidcTenantConfig.Credentials());
        oidcTenantConfig.getCredentials().setSecret(clientSecret);
        oidcTenantConfig.getToken().setAudience(Collections.singletonList("http://bc/api"));
        //oidcTenantConfig.setApplicationType(OidcTenantConfig.ApplicationType.HYBRID)1
        return Uni.createFrom().item(oidcTenantConfig);
    }*/
}


