package com.javaapi.test.spring.spring.feature.javaconfig.configurationAnnotataion;

public class Piano {
    private String name="Piano";
    private String sound;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Piano{");
        sb.append("name='").append(name).append('\'');
        sb.append(", sound='").append(sound).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

