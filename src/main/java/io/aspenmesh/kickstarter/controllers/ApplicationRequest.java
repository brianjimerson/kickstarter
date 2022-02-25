package io.aspenmesh.kickstarter.controllers;

public class ApplicationRequest {
    
    private String name;
    private String namespace;
    private String containerName;
    private String containerImage;
    private Integer containerPort;
    private String containerImagePullPolicy;
    private String deploymentStrategy;
    private Integer replicas;
    private Integer servicePort;
    private Boolean includeGateway;
    private Integer gatewayPort;
    private String gatewayPortName;
    private String protocol;
    private String host;
    private Boolean httpsRedirect;
    private String tlsMode;
    private String credentialName;
    private Boolean includeVirtualService;

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
    public String getContainerName() {
        return containerName;
    }
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }
    public String getContainerImage() {
        return containerImage;
    }
    public void setContainerImage(String containerImage) {
        this.containerImage = containerImage;
    }
    public Integer getContainerPort() {
        return containerPort;
    }
    public void setContainerPort(Integer containerPort) {
        this.containerPort = containerPort;
    }
    public String getContainerImagePullPolicy() {
        return containerImagePullPolicy;
    }
    public void setContainerImagePullPolicy(String containerImagePullPolicy) {
        this.containerImagePullPolicy = containerImagePullPolicy;
    }
    public String getDeploymentStrategy() {
        return deploymentStrategy;
    }
    public void setDeploymentStrategy(String deploymentStrategy) {
        this.deploymentStrategy = deploymentStrategy;
    }
    public Integer getReplicas() {
        return replicas;
    }
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }
    public Integer getServicePort() {
        return servicePort;
    }
    public void setServicePort(Integer servicePort) {
        this.servicePort = servicePort;
    }
    public Boolean getIncludeGateway() {
        return includeGateway;
    }
    public void setIncludeGateway(Boolean includeGateway) {
        this.includeGateway = includeGateway;
    }
    public Integer getGatewayPort() {
        return gatewayPort;
    }
    public void setGatewayPort(Integer gatewayPort) {
        this.gatewayPort = gatewayPort;
    }
    public String getGatewayPortName() {
        return gatewayPortName;
    }
    public void setGatewayPortName(String gatewayPortName) {
        this.gatewayPortName = gatewayPortName;
    }
    public String getProtocol() {
        return protocol;
    }
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public Boolean getHttpsRedirect() {
        return httpsRedirect;
    }
    public void setHttpsRedirect(Boolean httpsRedirect) {
        this.httpsRedirect = httpsRedirect;
    }
    public String getTlsMode() {
        return tlsMode;
    }
    public void setTlsMode(String tlsMode) {
        this.tlsMode = tlsMode;
    }
    public String getCredentialName() {
        return credentialName;
    }
    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }
    public Boolean getIncludeVirtualService() {
        return includeVirtualService;
    }
    public void setIncludeVirtualService(Boolean includeVirtualService) {
        this.includeVirtualService = includeVirtualService;
    }

}
