package com.javaapi.test.spring.feature.config.propertyeditor;

import org.springframework.beans.factory.annotation.Value;

/**

 */
public class PersonEntity {

    @Value("010-12345")
    private Telephone telephone;

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }
}
