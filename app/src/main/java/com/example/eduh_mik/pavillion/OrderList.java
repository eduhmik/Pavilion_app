package com.example.eduh_mik.pavillion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Eduh_mik on 5/16/2017.
 */

public class OrderList implements Serializable {
    List<OrderObject> orderObjectList;

    public List<OrderObject> getOrderObjectList() {
        return orderObjectList;
    }

    public void setOrderObjectList(List<OrderObject> orderObjectList) {
        this.orderObjectList = orderObjectList;
    }
}
