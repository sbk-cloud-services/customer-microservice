package de.leuphana.shop.customermicroservice.component.structure;

public interface PostAddress {
    public String getStreet();

    public void setStreet(String street);

    public String getHousenumber();

    public void setHousenumber(String housenumber);

    public String getZipcode();

    public void setZipcode(String zipcode);

    public String getCity();

    public void setCity(String city);
}
