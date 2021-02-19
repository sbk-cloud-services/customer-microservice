package de.leuphana.shop.customermicroservice.connector.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Customer")
public class CustomerEntity {
    @Id @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    @Embedded
    private PostAddressEntity postAddress;

    public Integer getId() {
        return id;
    }

    public PostAddressEntity getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(PostAddressEntity postAddress) {
        this.postAddress = postAddress;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
