package com.hexaware.entity;

public class Parcel02 {private double weight;

    public Parcel02(double weight) {
        this.weight = weight;
    }

    public void categorizeParcel() {
        String category;
        switch ((int) weight ) { // Categorization based on weight range
            case 0,1,2,3,4:
                category = "Light";
                break;
            case 5,6,7,8,9:
                category = "Medium";
                break;
            default:
                category = "Heavy";
                break;
        }
        System.out.println("The parcel is categorized as: " + category);
    }
}
