package model;

public class User {
    private String name;
    private int id;
    private String employeeNumber; // 統一

    private String password;

    public User(String name, String employeeNumber, String password) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
