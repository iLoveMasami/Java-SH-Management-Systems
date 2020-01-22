package com.ilovemasami.entity;

/**
 * @author yuzhezhu
 * @date 2020/01/22
 **/
public class Users {
  private Integer uid;
  private String username;
  private String password;

  public Users() {
  }

  public Users(Integer uid, String username, String password) {
    this.uid = uid;
    this.username = username;
    this.password = password;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Users{" +
            "uid=" + uid +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
