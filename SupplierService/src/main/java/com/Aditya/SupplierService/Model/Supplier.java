package com.Aditya.SupplierService.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
public class Supplier {
    @Id
    private String id;
    private String name;
    private String contact;
    private String email;
    private String address;

    

    public Supplier() {
        
    }

    public Supplier(String name, String contact, String email, String address) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
