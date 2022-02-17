package io.aspenmesh.kickstarter.controllers;

public class ServiceRequest {

    private String name;
    private String namespace;
    private Integer servicePort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Integer getServicePort() {
        return servicePort;
    }
    
    public void setServicePort(Integer port) {
        this.servicePort = port;
    }

    
}
