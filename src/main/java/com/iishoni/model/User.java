package com.iishoni.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -281169510916432654L;

    private Long id;
    private String username;
    private String password;
    private String nick;
    private Integer age;
    private Date birthday;
    private String mobile;
    private Long balance;
    private Date lastLoginTime;
}