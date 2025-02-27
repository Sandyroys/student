package com.example.snackapp.model;

import java.io.Serializable;
import java.util.Objects;
//用户
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;  //id自增

    private String username;  //用户名

    private String password;  //密码

    private String nickname;// 昵称

    private int headImage;  //头像

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String nickname, int headImage) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.headImage = headImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHeadImage() {
        return headImage;
    }

    public void setHeadImage(int headImage) {
        this.headImage = headImage;
    }

    /**
     * 用于登录比较用户账号密码
     *
     * @param o 待比较用户
     * @return 比较结果
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImage='" + headImage + '\'' +
                '}';
    }
}
