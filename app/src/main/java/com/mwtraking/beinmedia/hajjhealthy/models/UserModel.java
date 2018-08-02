package com.mwtraking.beinmedia.hajjhealthy.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mahmoud Waked
 */

public class UserModel implements Serializable {

  private int id ;
  private String firstName;
  private String secondName;
  private String dateOfBirth;
  private String gender;
  private String email;
  private List<Diseases> diseasesList ;
  private List<Restaurant> restaurantList ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Diseases> getDiseasesList() {
        return diseasesList;
    }

    public void setDiseasesList(List<Diseases> diseasesList) {
        this.diseasesList = diseasesList;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
