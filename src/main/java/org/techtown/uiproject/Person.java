package org.techtown.uiproject;
public class Person { //어르신 정보
    String name;
    String number;
    String address;
    String bisang;

    public Person(String name, String number, String address, String bisang) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.bisang = bisang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBisang() {
        return bisang;
    }

    public void setBisang(String bisang) {
        this.bisang = bisang;
    }
}
