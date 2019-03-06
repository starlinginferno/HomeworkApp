package com.fedex.homeworkapp.security.auth.jwt.verifier;

public interface TokenVerifier {
    public boolean verify(String jti);
}
