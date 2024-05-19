package com.example.config;

import io.quarkus.oidc.OidcTenantConfig;
import io.quarkus.oidc.TenantResolver;
import io.quarkus.oidc.runtime.TenantConfigBean;
import io.quarkus.oidc.runtime.TenantConfigContext;
import io.vertx.ext.web.RoutingContext;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.config.ConfigProvider;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CustomTenantConfigResolver implements TenantResolver {

    @Inject
    TenantConfigBean tenantConfigBean;

    private final Map<String, OidcTenantConfig> tenants = new HashMap<>();

    public CustomTenantConfigResolver() {
        OidcTenantConfig defaultTenant = new OidcTenantConfig();
        defaultTenant.setAuthServerUrl(ConfigProvider.getConfig().getValue("quarkus.oidc.auth-server-url", String.class));
        defaultTenant.setClientId(ConfigProvider.getConfig().getValue("quarkus.oidc.client-id", String.class));
        defaultTenant.setCredentials(new OidcTenantConfig.Credentials());
        defaultTenant.getCredentials().setSecret(ConfigProvider.getConfig().getValue("quarkus.oidc.credentials.secret", String.class));
        tenants.put("default", defaultTenant);
    }

    public void addTenant(String tenantId, OidcTenantConfig oidcTenantConfig) {
        tenants.put(tenantId, oidcTenantConfig);
    }

    @Override
    public String resolve(RoutingContext context) {
        return "default";  // for simplicity, always return default
    }
}
