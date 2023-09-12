package com.barber.barbershopmanager.model;

public class Location extends EntityId {
    String location;
    private String address;
    private String neighbor;
    private String city;
    private String state;
    private String Numb;

    public String getAddress() {return address; }

    public void setAddress(String address) {this.address = address; }

    public String getNeighbor() {return neighbor; }

    public void setNeighbor(String neighbor) {this.neighbor = neighbor; }

    public String getCity() {return city; }

    public void setCity(String city) {this.city = city; }

    public String getState() {return state; }

    public void setState(String state) {this.state = state; }

    public String getNumb() {return Numb; }

    public void setNumb(String numb) {Numb = numb; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
