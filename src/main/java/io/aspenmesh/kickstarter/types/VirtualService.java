package io.aspenmesh.kickstarter.types;

public class VirtualService extends KubernetesObject{
    

    public class VirtualServiceSpec implements Spec {

        private String host;
        private String gatewayName;
        private Destination destination;

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
        public Destination getDestination() {
            return destination;
        }
        public void setDestination(Destination destination) {
            this.destination = destination;
        }
    }

    public class Destination {
        private String host;
        private Integer portNumber;

        public String getHost() {
            return host;
        }
        public void setHost(String host) {
            this.host = host;
        }
        public Integer getPortNumber() {
            return portNumber;
        }
        public void setPortNumber(Integer portNumber) {
            this.portNumber = portNumber;
        }

        
    }
}
