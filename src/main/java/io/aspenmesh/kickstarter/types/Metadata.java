package io.aspenmesh.kickstarter.types;

import java.util.HashMap;
import java.util.Map;

public class Metadata {
    
    private String name;
    private String namespace;
    private Map<String, String> labels;
    private Map<String, String> annotations;

    public Metadata() {
        this.labels = new HashMap<String, String>();
        this.annotations = new HashMap<String, String>();
    }

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
    public Map<String, String> getLabels() {
        return labels;
    }
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
    public Map<String, String> getAnnotations() {
        return annotations;
    }
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }
    public void addLabel(String key, String value) {
        this.labels.put(key, value);
    }
    public void addAnnotation(String key, String value) {
        this.annotations.put(key, value);
    }

}
