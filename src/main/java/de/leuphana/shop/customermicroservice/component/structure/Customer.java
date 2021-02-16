package de.leuphana.shop.customermicroservice.component.structure;

public interface Customer {
    public Integer getId();

    public PostAddress getPostAddress();

    public void setPostAddress(PostAddress postAddress);

    public String getLastname();

    public void setLastname(String lastname);

    public String getFirstname();

    public void setFirstname(String firstname);

    public void setId(Integer id);
}
