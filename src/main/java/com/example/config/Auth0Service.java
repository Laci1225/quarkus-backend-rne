package com.example.config;

/*
@ApplicationScoped
public class Auth0Service {

    private static final OkHttpClient client = new OkHttpClient();
    private static final Logger log = Logger.getLogger(Auth0Service.class);
    @Inject
    ObjectMapper objectMapper;
    @Inject
    @ConfigProperty(name = "auth0.management.audience")
    String audience;
    @Inject
    @ConfigProperty(name = "auth0.management.api.token")
    String accessToken;

    public Uni<AppMetadata> getUserInfo(String userId) {
        return Uni.createFrom().item(Unchecked.supplier(() -> {
            String auth0ManagementApiUrl = audience + "users/" + userId;
            log.error("Auth0 Management API URL: " + auth0ManagementApiUrl);
            Request request = new Request.Builder()
                    .url(auth0ManagementApiUrl)
                    .header("Authorization", "Bearer " + accessToken)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                log.error("Response: " + response);
                if (response.isSuccessful() && response.body() != null) {
                    var responseBody = objectMapper.readValue(response.body().string(), Map.class);
                    log.error(responseBody);
                    return objectMapper.convertValue(responseBody.get("app_metadata"), AppMetadata.class);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new AppMetadata();
        }));
    }

    /*public void createUser(String email, String id, String givenName, String familyName, Role role) {
        MediaType mediaType = MediaType.parse("application/json");
        UserData userData = new UserData(
                email,
                new AppMetadata(id, role.name()),
                familyName,
                givenName,
                "email");
        RequestBody body;
        try {
            body = RequestBody.create(
                    new ObjectMapper().writeValueAsString(userData),
                    mediaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Request request = new Request.Builder()
                .url(audience + "users")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = Objects.requireNonNull(response.body()).string();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                String userId = jsonNode.get("user_id").asText();
                RequestBody body2 = RequestBody.create(
                        "{\"users\":[\"" + userId + "\"]}",
                        mediaType);
                Request request2 = new Request.Builder()
                        .url(audience + "roles/" + role.getRoleId() + "/users")
                        .method("POST", body2)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
                Response response2 = client.newCall(request2).execute();
                log.error(response2.body().string());
            } else {
                log.error("Error: " + response.code() + ", " + response.message());
                log.error(response.body().string());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(String authUser) {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create("", mediaType);
        Request request = new Request.Builder()
                .url(audience + "users/" + URLEncoder.encode(authUser, StandardCharsets.UTF_8))
                .method("DELETE", body)
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            log.error(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
//}
