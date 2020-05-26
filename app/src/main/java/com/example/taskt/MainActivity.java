package com.example.taskt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ArrayList<Order> orders =  SetOrders();

        RecyclerView orders_list = findViewById(R.id.orders_list);
        TextView welcome_message = findViewById(R.id.welcome_message);
        welcome_message.setText("Список товаров");
        orders_list.setAdapter(new Orders_view_adapter(orders, this));
        orders_list.setLayoutManager(new LinearLayoutManager(this));

    }
    public ArrayList<Order> SetOrders(){
        ArrayList<Order> orders = new ArrayList<>();
        Order order1 = new Order(1, "Улица Радищева 8", "Иванов Иван Иванович", "Драгоценности", 1524.22f);
        orders.add(order1);
        Order order2 = new Order(2, "Улица Ленина 87", "Петоров Петр Петрович", "Электроника", 152454f);
        orders.add(order2);
        Order order3 = new Order(3, "Улица ПЛК 45", "Васин Петр Сергеевич", "Глобус", 54.22f);
        orders.add(order3);
        Order order4 = new Order(4, "Улица Школьная 52", "Иванов Иван Иванович", "Электроника", 28524.2f);
        orders.add(order4);
        Order order5 = new Order(5, "Улица Школьная 52", "Сергеев Сергей Сергеевич", "Драгоценности", 45878.22f);
        orders.add(order5);
        Order order6 = new Order(6, "Улица Дзержинского 1", "Викторов Виктор Викторович", "Пряности", 1.22f);
        orders.add(order6);
        Order order7 = new Order(7, "Улица Ленина 40", "Иванов Иван Иванович", "Книги", 1568.22f);
        orders.add(order7);
        Order order8= new Order(8, "Улица Радищева 25", "Алексеев Алексей Алексеевич", "Пряности", 18744.22f);
        orders.add(order8);
        Order order9 = new Order(9, "Улица Щепкина 12", "Денисов Сергей Николаевич", "Драгоценности", 89754.22f);
        orders.add(order9);
        return orders;
    }
}
