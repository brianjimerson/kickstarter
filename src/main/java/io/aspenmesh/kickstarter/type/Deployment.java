package io.aspenmesh.kickstarter.type;

public class Deployment extends KubernetesObject {

    public enum DeploymentStrategy {

        RECREATE("Recreate"),
        ROLLING_UPDATE("RollingUpdate");

        private String deploymentStrategy;

        private DeploymentStrategy(String deploymentStrategy) {
            this.deploymentStrategy = deploymentStrategy;
        }

        public String getValue() {
            return this.deploymentStrategy;
        }

        public static DeploymentStrategy findByValue(String value) {
            for (DeploymentStrategy ds : values()) {
                if (ds.getValue().equalsIgnoreCase(value)) {
                    return ds;
                }
            }
            return null;
        }
    }
    
    public class DeploymentSpec implements Spec {

        private Integer replicas;
        private DeploymentStrategy deploymentStrategy;
        private PodSpec pod;

        public Integer getReplicas() {
            return replicas;
        }

        public void setReplicas(Integer replicas) {
            this.replicas = replicas;
        }

        public DeploymentStrategy getDeploymentStrategy() {
            return deploymentStrategy;
        }

        public void setDeploymentStrategy(DeploymentStrategy deploymentStrategy) {
            this.deploymentStrategy = deploymentStrategy;
        }

        public PodSpec getPod() {
            return pod;
        }

        public void setPod(PodSpec pod) {
            this.pod = pod;
        }

    }
}
