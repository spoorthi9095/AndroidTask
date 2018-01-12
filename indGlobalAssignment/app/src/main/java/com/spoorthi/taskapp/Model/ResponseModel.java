package com.spoorthi.taskapp.Model;

/**
 * Created by Spoorthi on 1/12/2018.
 */

public class ResponseModel
{

    /**
     * status : true
     * status_code : 200
     * role : 3
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjE0LCJpc3MiOiJodHRwOi8vcGhwbGFyYXZlbC05MjIyNi0zNDY2NTkuY2xvdWR3YXlzYXBwcy5jb20vYXBpL2F1dGgvbG9naW4iLCJpYXQiOjE1MTU2OTczODUsImV4cCI6MTUxNTcwMDk4NSwibmJmIjoxNTE1Njk3Mzg1LCJqdGkiOiJQMmlhYVREZ3lEbFBxRENhIn0.hszcpFt0kVNkSPM1lEkIjDVhl15UelHCCfMzehadMeU
     */

    private boolean status;
    private int status_code;
    private String role;
    private String token;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
