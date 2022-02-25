package io.aspenmesh.kickstarter.controllers;

public class VirtualServiceRequest {
    
    private String name;
    private String namespace;
    private String host;
    private String gatewayName;
    private String destinationHost;
    private Integer destinationPortNumber;

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
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getGatewayName() {
        return gatewayName;
    }
    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }
    public String getDestinationHost() {
        return destinationHost;
    }
    public void setDestinationHost(String destinationHost) {
        this.destinationHost = destinationHost;
    }
    public Integer getDestinationPortNumber() {
        return destinationPortNumber;
    }
    public void setDestinationPortNumber(Integer destinationPortNumber) {
        this.destinationPortNumber = destinationPortNumber;
    }
}
