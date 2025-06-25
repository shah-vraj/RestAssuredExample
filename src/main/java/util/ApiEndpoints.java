package util;

public enum ApiEndpoints {
    USERS("/api/users");

    public final String path;

    ApiEndpoints(String path) {
        this.path = path;
    }
}
