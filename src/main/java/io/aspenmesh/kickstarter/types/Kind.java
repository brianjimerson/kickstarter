package io.aspenmesh.kickstarter.types;

public enum Kind {
    
    DEPLOYMENT("apps/v1", "Deployment"),
    SERVICE("v1", "Service"),
    GATEWAY("networking.istio.io/v1alpha3", "Gateway"),
    VIRTUAL_SERVICE("networking.istio.io/v1alpha3", "VirtualService"),
    DESTINATION_RULE("networking.istio.io/v1alpha3", "DestinationRule"),
    SERVICE_ENTRY("networking.istio.io/v1alpha3", "ServiceEntry"),
    AUTHORIZATION_POLICY("security.istio.io/v1beta1", "AuthorizationPolicy");

    private final String apiVersion;
    private final String kind;

    private Kind(String apiVersion, String kind) {
        this.apiVersion = apiVersion;
        this.kind = kind;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getKind() {
        return kind;
    }

    public static Kind findByKindValue(String kind) {
        for (Kind k : values()) {
            if (k.getKind().equalsIgnoreCase(kind)) {
                return k;
            }
        }
        return null;
    }

}
