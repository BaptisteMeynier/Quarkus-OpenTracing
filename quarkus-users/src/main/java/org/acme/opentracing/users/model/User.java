package org.acme.opentracing.users.model;


public class User {
    private String name;

    private transient String[] managedPtf;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String[] managedPtf) {
        this.name = name;
        this.managedPtf = managedPtf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getManagedPtf() {
        return managedPtf;
    }

    public void setManagedPtf(String[] managedPtf) {
        this.managedPtf = managedPtf;
    }
}
