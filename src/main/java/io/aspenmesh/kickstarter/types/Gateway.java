package io.aspenmesh.kickstarter.types;

import java.util.List;
import java.util.Map;

public class Gateway extends KubernetesObject {
 
    public class GatewaySpec implements Spec {
        
        private Map<String, String> selector;
        private Server server;
        
        public Map<String, String> getSelector() {
            return selector;
        }
        public void setSelector(Map<String, String> selector) {
            this.selector = selector;
        }
        public Server getServer() {
            return server;
        }
        public void setServer(Server server) {
            this.server = server;
        }
        
    }

    public class Server {

        private Port port;
        private String bind;
        private List<String> hosts;
        private String name;
        private ServerTLSSettings tls;

        public Port getPort() {
            return port;
        }
        public void setPort(Port port) {
            this.port = port;
        }
        public String getBind() {
            return bind;
        }
        public void setBind(String bind) {
            this.bind = bind;
        }
        public List<String> getHosts() {
            return hosts;
        }
        public void setHosts(List<String> hosts) {
            this.hosts = hosts;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public ServerTLSSettings getTls() {
            return tls;
        }
        public void setTls(ServerTLSSettings tls) {
            this.tls = tls;
        }

        
    }

    public class ServerTLSSettings {
        private Boolean httpsRedirect;
        private TLSMode mode;
        private String serverCertificate;
        private String privateKey;
        private String caCertificates;
        private String credentialName;

        public Boolean getHttpsRedirect() {
            return httpsRedirect;
        }
        public void setHttpsRedirect(Boolean httpsRedirect) {
            this.httpsRedirect = httpsRedirect;
        }
        public TLSMode getMode() {
            return mode;
        }
        public void setMode(TLSMode mode) {
            this.mode = mode;
        }
        public String getServerCertificate() {
            return serverCertificate;
        }
        public void setServerCertificate(String serverCertificate) {
            this.serverCertificate = serverCertificate;
        }
        public String getPrivateKey() {
            return privateKey;
        }
        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }
        public String getCaCertificates() {
            return caCertificates;
        }
        public void setCaCertificates(String caCertificates) {
            this.caCertificates = caCertificates;
        }
        public String getCredentialName() {
            return credentialName;
        }
        public void setCredentialName(String credentialName) {
            this.credentialName = credentialName;
        }

        
    }

    public class Port {

        private Integer port;
        private Integer targetPort;
        private String name;
        private Protocol protocol;

        public Integer getPort() {
            return port;
        }
        public void setPort(Integer port) {
            this.port = port;
        }
        public Integer getTargetPort() {
            return targetPort;
        }
        public void setTargetPort(Integer targetPort) {
            this.targetPort = targetPort;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Protocol getProtocol() {
            return protocol;
        }
        public void setProtocol(Protocol protocol) {
            this.protocol = protocol;
        }
    }
    
}
