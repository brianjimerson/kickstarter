package io.aspenmesh.kickstarter.types;

public enum TLSMode {
    
    PASSTHROUGH("PASSTHROUGH"),
    SIMPLE("SIMPLE"),
    MUTUAL("MUTUAL"),
    AUTO_PASSTHROUGH("AUTO_PASSTHROUGH"),
    ISTIO_MUTUAL("ISTIO_MUTUAL");

    private String tlsMode;

    private TLSMode(String tlsMode) {
        this.tlsMode = tlsMode;
    }

    public String getTLSMode() {
        return this.tlsMode;
    }

    public static TLSMode findByValue(String tlsMode) {

        for (TLSMode t : values()) {
            if (t.getTLSMode().equalsIgnoreCase(tlsMode)) {
                return t;
            }
        }

        return null;

    }


}
