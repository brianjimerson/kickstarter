package io.aspenmesh.kickstarter.controllers;

public class GatewayRequest {
    
    private String name;
    private String namespace;
    private String serverName;
    private Integer port;
    private Integer targetPort;
    private String portName;
    private String protocol;
    private String host;
    private Boolean httpsRedirect;
    private String tlsMode;
    private String credentialName;
    
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
    public String getServerName() {
        return serverName;
    }
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
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
    public String getPortName() {
        return portName;
    }
    public void setPortName(String portName) {
        this.portName = portName;
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
    @Override
    public String toString() {
        return "GatewayRequest [credentialName=" + credentialName + ", host=" + host + ", httpsRedirect="
                + httpsRedirect + ", name=" + name + ", namespace=" + namespace + ", port=" + port + ", portName="
                + portName + ", protocol=" + protocol + ", serverName=" + serverName
                + ", targetPort=" + targetPort + ", tlsMode=" + tlsMode + "]";
    }
    

}
