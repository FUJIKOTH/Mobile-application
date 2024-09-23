package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class OrderActivity extends AppCompatActivity {

    private ImageView meatImage;
    private TextView meatName;
    private TextView meatType;
    private TextView meatOrigin;
    private TextView meatPrice;
    private TextView quantityText;
    private double pricePerUnit;
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        meatImage = findViewById(R.id.meat_image);
        meatName = findViewById(R.id.meat_name);
        meatType = findViewById(R.id.meat_type);
        meatOrigin = findViewById(R.id.meat_origin);
        meatPrice = findViewById(R.id.meat_price);
        quantityText = findViewById(R.id.quantity_text);

        Button increaseQuantityButton = findViewById(R.id.increase_quantity);
        Button decreaseQuantityButton = findViewById(R.id.decrease_quantity);
        Button confirmOrderButton = findViewById(R.id.confirm_order);

        Intent intent = getIntent();
        String name = intent.getStringExtra("meat_name");
        String type = intent.getStringExtra("meat_type");
        String origin = intent.getStringExtra("meat_origin");
        pricePerUnit = intent.getDoubleExtra("meat_price", 0.0);
        String imageUrl = intent.getStringExtra("meat_image");

        meatName.setText(name);
        meatType.setText(type);
        meatOrigin.setText(origin);
        updatePrice();

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(meatImage);

        increaseQuantityButton.setOnClickListener(v -> {
            quantity++;
            updateQuantityAndPrice();
        });

        decreaseQuantityButton.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                updateQuantityAndPrice();
            }
        });

        confirmOrderButton.setOnClickListener(v -> {
            Intent payIntent = new Intent(OrderActivity.this, PayMoneyActivity.class);
            payIntent.putExtra("total_price", quantity * pricePerUnit);
            startActivity(payIntent);
        });
    }

    private void updateQuantityAndPrice() {
        quantityText.setText(String.valueOf(quantity));
        updatePrice();
    }

    private void updatePrice() {
        meatPrice.setText(String.format("฿%.2f", pricePerUnit * quantity));
    }
}
