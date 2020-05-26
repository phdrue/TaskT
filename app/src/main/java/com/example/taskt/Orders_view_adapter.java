package com.example.taskt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Orders_view_adapter extends RecyclerView.Adapter<Orders_view_adapter.ViewHolder>{


    private ArrayList<Order> myOrders;
    private Context myContext;

    public Orders_view_adapter(ArrayList<Order> myOrders, Context myContext) {
        this.myOrders = myOrders;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.order_id.setText("Номер заказа: ".concat(Integer.toString(myOrders.get(position).id)));
        holder.order_price.setText("Стоимость заказа: ".concat(Float.toString(myOrders.get(position).price)));
        holder.order_relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "Заказ ".concat(Integer.toString(myOrders.get(position).id)),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(myContext, OrderActivity.class);
                Gson gson = new Gson();

                Order my_order = myOrders.get(position);
                String my_string_order = gson.toJson(my_order);
                intent.putExtra("order", my_string_order);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myOrders.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView order_id;
        TextView order_price;
        RelativeLayout  order_relative_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            order_id = itemView.findViewById(R.id.order_id);
            order_price = itemView.findViewById(R.id.order_price);
            order_relative_layout = itemView.findViewById(R.id.order_relative_layout);
        }
    }
}
