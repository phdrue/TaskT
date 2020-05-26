package com.example.taskt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle args = getIntent().getExtras();
        String my_order = args.getString("order");
        Gson gson = new Gson();
        Order order = gson.fromJson(my_order, Order.class);

        String asf =" asfdsa";
        TextView order_id = findViewById(R.id.order_id);
        TextView order_address = findViewById(R.id.order_address);
        TextView order_client = findViewById(R.id.order_client);
        TextView order_product = findViewById(R.id.order_product);
        TextView order_price = findViewById(R.id.order_price);

        order_id.setText("Номер заказа: ".concat( Integer.toString(order.id)));
        order_address.setText("Адрес доставки: ".concat(order.address));
        order_client.setText("Заказчик: ".concat(order.client));
        order_product.setText("Предмет заказа: ".concat(order.product));
        order_price.setText("Стоимость заказа: ".concat(Float.toString(order.price)));
    }
}
