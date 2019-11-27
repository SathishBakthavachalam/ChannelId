package com.example.clientmap;

public class ClientMap {


    public int id;
    public String emp_name;
    //@JsonRawValue
    public int age;

    public ClientMap(int id, String emp_name, int age) {
        this.id = id;
        this.emp_name = emp_name;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
