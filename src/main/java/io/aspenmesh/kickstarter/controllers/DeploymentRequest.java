package io.aspenmesh.kickstarter.controllers;

public class DeploymentRequest {

    private String name;
    private String namespace;
    private String containerName;
    private String containerImage;
    private Integer containerPort;
    private String containerImagePullPolicy;
    private String serviceAccountName;
    private String deploymentStrategy;
    private Integer replicas;

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

    public String getServiceAccountName() {
        return serviceAccountName;
    }

    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
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
    
}
