package com.luwojtaszek.springbootjsp.model;

/**
 * Created by andresdkm on 17/01/18.
 */
public class UserModel {

    private Long id;
    private String site_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }
}
