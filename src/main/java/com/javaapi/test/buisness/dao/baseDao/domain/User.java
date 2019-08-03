package com.javaapi.test.buisness.dao.baseDao.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "i_user")
@Cacheable
public class User implements Serializable {
    private static final long serialVersionUID = 5177699062365176136L;

    @Id
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //	@Generated
//	@GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid",strategy="uuid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + "]";
    }
}
