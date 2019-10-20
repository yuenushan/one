package com.example.boot.bootspringjdbc.domain;

public class CustomerDomain {
    private Long id;
    private String firstName;
    private String lastName;

    public CustomerDomain(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "CustomerDomain{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
