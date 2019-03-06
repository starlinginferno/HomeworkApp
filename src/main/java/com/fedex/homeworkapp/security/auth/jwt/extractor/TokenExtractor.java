package com.fedex.homeworkapp.security.auth.jwt.extractor;

public interface TokenExtractor {
    String extract(String payload);
}
