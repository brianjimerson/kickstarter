package io.aspenmesh.kickstarter.type;

public abstract class KubernetesObject {
    
    private Kind kind;
    private Metadata metadata;
    private Spec spec;

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Kind getKind() {
        return kind;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }
}