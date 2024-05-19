package com.example.config;

import io.quarkus.oidc.OidcTenantConfig;
import io.quarkus.oidc.TenantResolver;
import io.vertx.ext.web.RoutingContext;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.ConfigProvider;

import java.util.HashMap;
import java.util.Map;
/*
@ApplicationScoped
public class CustomTenantConfigResolver implements TenantResolver {

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
        // Extract the tenant ID from the request, if applicable
        String tenantId = extractTenantId(context);

        // Check if the tenant ID is valid and exists in the tenants map
        if (tenantId != null && tenants.containsKey(tenantId)) {
            return tenantId; // Return the resolved tenant ID
        } else {
            return "default"; // Return the default tenant if no specific tenant is found
        }
    }
    private String extractTenantId(RoutingContext context) {
        // Logic to extract tenant ID from the request, e.g., from headers, URL, etc.
        // For simplicity, let's assume the tenant ID is extracted from a request header
        return context.request().getHeader("Tenant-Id");
    }
}*/

