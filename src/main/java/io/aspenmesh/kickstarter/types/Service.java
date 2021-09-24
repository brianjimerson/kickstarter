package io.aspenmesh.kickstarter.types;

public class Service extends KubernetesObject {


    public class ServiceSpec implements Spec {

        private Integer port;

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

    }
}
