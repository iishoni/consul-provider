package com.iishoni.web;

public interface Urls {

    /**
     * 用户
     */
    interface User {
        String ROOT = "/user";
        String GET_USER_LIST = "";
        String GET_USER_INFO = "/{userId}";
        String SAVE_USER = "";
        String UPDATE_USER = "";
        String DELETE_USER = "/{userId}";
    }

}
