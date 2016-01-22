package com.yinom.rdc.colin.yin.bean;

/**
 * Created by Colin on 1/22/2016.
 */
public class PhoneNumber {
    private String Province;
    private String City;
    private int AreaCode;
    private int zip;
    private String Company;
    private String card;

    public PhoneNumber() {
    }

    public PhoneNumber(String province, String city, int areaCode, int zip, String company,
                       String card) {
        Province = province;
        City = city;
        AreaCode = areaCode;
        this.zip = zip;
        Company = company;
        this.card = card;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
