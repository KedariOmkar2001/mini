package org.com.app.spring_boot_backend.entities.Employee;

public class Employee {

    String name;
    int age;
    int networth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNetworth() {
        return networth;
    }

    public void setNetworth(int networth) {
        this.networth = networth;
    }

    public Employee(String name, int age, int networth) {
        this.name = name;
        this.age = age;
        this.networth = networth;
    }

}
