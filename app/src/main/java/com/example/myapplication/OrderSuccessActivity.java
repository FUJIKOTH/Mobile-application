package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        Intent receiveIntent = getIntent();
        double totalPrice = receiveIntent.getDoubleExtra("total_price", 0.0);

        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(String.format("ยอดรวมการชำระเงิน: ฿%.2f", totalPrice));

        // เพิ่ม ImageView เพื่อแสดงไอคอน
        ImageView iconImageView = findViewById(R.id.icon_image_view);
        iconImageView.setImageResource(R.drawable.ic_success); // เปลี่ยน your_icon_name เป็นชื่อไฟล์ของไอคอน

        Button backToHomeButton = findViewById(R.id.btn_back_to_home);
        backToHomeButton.setOnClickListener(v -> {
            Intent mainIntent = new Intent(OrderSuccessActivity.this, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainIntent);
            finish();
        });
    }
}
