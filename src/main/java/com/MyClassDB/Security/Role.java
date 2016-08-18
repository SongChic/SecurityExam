package com.MyClassDB.Security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	private String name;
    private List<Privilege> privileges;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }
    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
