package com.toDoList.spring.model;


import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Entity
@Table(name = "User_tbl")
/*@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
public class User implements java.io.Serializable {
    private Integer userId;
    private String userName;
    private String password;
    /*private List<Task> tasks;*/

    public User() {
    }

    public User(Integer userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    @Id
    @Column(name = "userId", unique = true, nullable = false)
    /*@GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "userName", nullable = false, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*@OneToMany(mappedBy = "user")
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
