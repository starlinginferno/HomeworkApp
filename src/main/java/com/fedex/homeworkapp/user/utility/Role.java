package com.fedex.homeworkapp.user.utility;

public enum Role {
    STUDENT, TEACHER;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
