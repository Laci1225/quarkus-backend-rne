package com.example.constants;

public enum Role {
    ADMINISTRATOR("rol_ZVbZjai55NpwOwhV"),
    RECEPTIONIST("rol_8zxbgZfLD9gqdT9V"),
    TEACHER("rol_eByb3iqY6qSouy7u"),
    PARENT("rol_Mjt9yu2PlPadWRn5");

    public String getRoleId() {
        return roleId;
    }

    Role(String roleId) {
        this.roleId = roleId;
    }

    private final String roleId;
}

