package com.example.eduh_mik.pavillion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class ReceiptActivity extends AppCompatActivity {
    TextView receipt;
    View frameLayout;
    Intent intent;
    Bundle getFood;
    int i;
    String foods;
   //List <String> listoffood = new ArrayList<String>();
    String[] receiveOrderItem = new String[25];
    LinearLayout view;





  //defined an string variable e1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        receipt = (TextView) findViewById(R.id.inte);
        view = (LinearLayout) findViewById(R.id.container);
        OrderList orderList = (OrderList) getIntent().getSerializableExtra("orderedFood");
        List<OrderObject> orderObjects = orderList.getOrderObjectList();
        for(OrderObject orderObject : orderObjects){
            TextView text=new TextView(ReceiptActivity.this);
            text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            text.setText(String.valueOf(orderObject.getQuantity())+ "                           "+ orderObject.getName()+"                           "+String.valueOf(orderObject.getAmmount())+"\n");

            view.addView(text);
            text.setVisibility(View.VISIBLE);
        }


        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());

        String name = "MULTIMEDIA UNIVERSITY OF KENYA";

        int random = (int)Math.ceil(Math.random()*10000);

        receipt.setText(name+"\n" + "\n"+"Receipt Number:" + " "+ random+"\n"+"\n"+"Date:"+" " +date+"\n"+"Qty"+ "                           "
                +"Description"+ "                           "+"Amount"+"\n");

    }
}








