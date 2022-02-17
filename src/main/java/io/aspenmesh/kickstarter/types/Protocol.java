package io.aspenmesh.kickstarter.types;

public enum Protocol {

    HTTP("HTTP"),
    HTTPS("HTTPS"),
    GRPC("GRPC"),
    HTTP2("HTTP2"),
    MONGO("MONGO"),
    TCP("TCP"),
    TLS("TLS");

    private String protocol;

    private Protocol(String protocol) {
        this.protocol = protocol;
    }

    public String getValue() {
        return this.protocol;
    }

    public static Protocol findByValue(String value) {
        for (Protocol p : values()) {
            if (p.getValue().equalsIgnoreCase(value)) {
                return p;
            }
        }
        return null;
    }
}
