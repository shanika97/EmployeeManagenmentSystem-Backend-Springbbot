package com.example.SpringAngular.entity;



import jakarta.persistence.*;



@Entity
public class Employee {
    @Id
//    @Column(name="employee_id",length=50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

//    @Column(name="employee_name",length=50)
    private String name;

//    @Column(name = "employee_email",length=100)
    private String email;

//    @Column(name = "employee mobile",length=10)
    private String phone;

//    @Column(name = "employee_username",length=10)
    private String username;

//    @Column(name="employee_password",length=8)
    private String password;


    public Employee() {

    }



    public Employee(int id, String name, String email, String phone, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Employee(String name, String email, String phone, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
