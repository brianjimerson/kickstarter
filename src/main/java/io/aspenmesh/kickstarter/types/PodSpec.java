package io.aspenmesh.kickstarter.types;

import java.util.List;

public class PodSpec {

    private String serviceAccountName;
    private List<Container> containers;
    private List<Container> initContainers;
    
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public List<Container> getInitContainers() {
        return initContainers;
    }

    public void setInitContainers(List<Container> initContainers) {
        this.initContainers = initContainers;
    }

}
