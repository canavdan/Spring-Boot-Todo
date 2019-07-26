package com.canavdan.todo.security;

public class SecurityConstants {
    public static final String SECRET = "5ba9b05f-267f-472a-bf2a-ecae5da6a9e9";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v1/member/sign-up";
}
