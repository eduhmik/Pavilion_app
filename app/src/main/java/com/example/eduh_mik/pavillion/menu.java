package com.example.eduh_mik.pavillion;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduh_mik.pavillion.R;

import java.util.ArrayList;
import java.util.List;

// I want to pass this string to the another activity
public class menu extends AppCompatActivity {
    TextView receipt, view;
    EditText qty;
    String itemSelected;
    Spinner spinner;
    String texts, quantity, total, message;
    View linearLayout;
   String [] listoffood = new String[25];
    Bundle bundle;
    int amt, num1, num2, num3, num4, num_x, valueof;
    List<OrderObject> orderObjectList;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        receipt = (TextView) findViewById(R.id.inte);
    qty = (EditText)findViewById(R.id.et_add);


//   num1 = Integer.parseInt(qty.getText().toString());
//    //num1 = qty;
//    int quanti = num1;
//    price = valueof;
//        amt =  num1 * price;





   // qty = (EditText)findViewById(R.id.et_add);

    linearLayout =    findViewById(R.id.activity_menu);

    orderObjectList = new ArrayList<>();

    Button button=(Button)findViewById(R.id.btnadd) ;
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            multiply();
            createTextView();
            OrderObject orderObject = new OrderObject();

            String name = spinner.getSelectedItem().toString();
            int quantity = Integer.parseInt(qty.getText().toString());
            int amt = multiply();

            orderObject.setName(name);
            orderObject.setAmmount(amt);
            orderObject.setQuantity(quantity);

            orderObjectList.add(orderObject);
            add();
            createTotal();

            Toast.makeText(menu.this, texts+" "+"added", Toast.LENGTH_SHORT).show();
        }

        private void createTotal() {
            TextView text=new TextView(menu.this);
            text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            text.setText("Total:"+" "+num_x);

            ((LinearLayout) linearLayout).addView(text);
            text.setVisibility(View.VISIBLE);
        }
    });

    total = texts +" "+ qty.getText().toString();

    spinner =(Spinner)findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.foods, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            itemSelected = parent.getItemAtPosition(position).toString();


            if (itemSelected.equals("Tea")) {
                texts = "Tea";
                valueof = 10;

                //listoffood.add(texts);

            } else if (itemSelected.equals("Coffee")) {
                texts = "Coffee";
                valueof = 10;
               // listoffood.add(texts);

            } else if (itemSelected.equals("Bread")) {
                texts = "Bread";
                valueof = 10;
                //listoffood.add(texts);

            } else if (itemSelected.equals("Andazi")) {
                texts = "Andazi";
                valueof = 10;
                //listoffood.add(texts);

            } else if (itemSelected.equals("Doughnut")) {
                texts = "Doughnut";
                valueof = 10;
                //listoffood.add(texts);

            } else if (itemSelected.equals("Ugali")) {
                texts = "Ugali";
                valueof = 10;

            } else if (itemSelected.equals("Githeri")) {
                texts = "Githeri";
                valueof = 20;

            } else if (itemSelected.equals("Rice")) {
                texts = "Rice";
                valueof = 20;

            } else if (itemSelected.equals("Chapati")) {
                texts = "Chapati";
                valueof = 10;

            } else if (itemSelected.equals("Beans")) {
                texts = "Beans";
                valueof = 15;

            } else if (itemSelected.equals("Ndengu")) {
                texts = "Ndengu";
                valueof = 20;

            } else if (itemSelected.equals("Beef")) {
                texts = "Beef";
                valueof = 40;

            } else if (itemSelected.equals("Goat Meat")) {
                texts = "Goat Meat";
                valueof = 60;

            } else if (itemSelected.equals("Chicken")) {
                texts = "Chicken";
                valueof =60;

            } else if (itemSelected.equals("Egg Curry")) {
                texts = "Egg Curry";
                valueof =20;

            } else if (itemSelected.equals("Boiled Egg")) {
                texts = "Boiled Egg";
                valueof = 15;

            } else if (itemSelected.equals("Fried Egg")) {
                texts = "Fried Egg";
                valueof = 20;

            } else if (itemSelected.equals("Watermelon")) {
                texts = "Watermelon";
                valueof = 10;

            } else if (itemSelected.equals("Banana")) {
                texts = "Banana";
                valueof = 10;

            } else if (itemSelected.equals("Veges")) {
                texts = "Veges";
                valueof = 5;
            }


//        setSupportActionBar(receipt);
            Button click = (Button) findViewById(R.id.btnby); // Here i have defined the button

            click.setOnClickListener(new View.OnClickListener() {  //Click event on button
                                         @Override
                                         public void onClick(View v) {




                                            /* Intent intent = new Intent(menu.this, ReceiptActivity.class);
                                             intent.putExtra("key", message);
                                             startActivity(intent);*/
                                             sendFood();


                                         }
                                     }

            );

//            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//            fab.setOnClickListener(new View.OnClickListener()
//
//            {
//                @Override
//                public void onClick(View view) {
//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//
//                }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuitem, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
        return true;
        }

        return super.onOptionsItemSelected(item);
        }
    public int multiply(){
        num1 = Integer.parseInt(qty.getText().toString());

        amt =  num1 * valueof;

        num_x = num_x+amt;

        return amt;

    }
    public int add(){
        return num_x;

    }



//@Override
//public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_receipt);
//        }
//        }




//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_menu);














    public void createTextView(){
        TextView text=new TextView(menu.this);
        text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        text.setText(qty.getText().toString() + "                           "+ texts+"                           "+amt+"\n");

        ((LinearLayout) linearLayout).addView(text);
        text.setVisibility(View.VISIBLE);

    }
    public void sendFood(){
        //bundle.putStringArrayList("orderedFood", (ArrayList<String>) listoffood);
       // bundle.putString("orderedFood", String.valueOf(listoffood));
        Intent send = new Intent(menu.this,ReceiptActivity.class);
        OrderList orderList = new OrderList();
        orderList.setOrderObjectList(orderObjectList);
        send.putExtra("orderedFood",orderList);
        startActivity(send);
    }

}
