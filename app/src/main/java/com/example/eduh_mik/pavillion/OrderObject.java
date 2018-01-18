package com.example.eduh_mik.pavillion;

import java.io.PushbackInputStream;
import java.io.Serializable;

/**
 * Created by Eduh_mik on 5/16/2017.
 */

public class OrderObject implements Serializable{
    String name;
    int quantity;
    int ammount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
}

class Food extends recycleview {
    private String quantity;
    private String texts;
    private Integer amt;

    public Food(){}

    public Food(String qty, String texts, Integer amt) {
        this.quantity = qty;
        this.texts = texts;
        this.amt = amt;

    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public int getAmt(){
        return  amt;

    }
    public void setAmt(int amt){
        this.amt = amt;
    }
    public String getFood() {
        return quantity + " " + texts+ " "+ amt;
    }


}
