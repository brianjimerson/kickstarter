package io.aspenmesh.kickstarter.type;

public enum ImagePullPolicy {
    ALWAYS("Always"),
    NEVER("Never"),
    IF_NOT_PRESENT("IfNotPresent");

    private String imagePullPolicy;


    private ImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }
    
    public String getValue() {
        return imagePullPolicy;
    }

    public static ImagePullPolicy findByValue(String value) {
        for (ImagePullPolicy p : values()) {
            if (p.getValue().equalsIgnoreCase(value)) {
                return p;
            }
        }
        return null;
    }
}
