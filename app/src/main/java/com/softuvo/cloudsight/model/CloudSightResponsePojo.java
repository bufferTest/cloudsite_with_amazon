package com.softuvo.cloudsight.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloudSightResponsePojo {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("ttl")
    @Expose
    private Integer ttl;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("name")
    @Expose
    private String name;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}