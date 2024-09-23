package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PayMoneyActivity extends AppCompatActivity {

    private TextView totalPriceText;
    private double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_money);

        totalPriceText = findViewById(R.id.total_price_text);

        Intent intent = getIntent();
        totalPrice = intent.getDoubleExtra("total_price", 0.0);
        totalPriceText.setText(String.format("ยอดรวมทั้งหมด: ฿%.2f", totalPrice));

        // โหลดรูปภาพจาก URL
        String cashImageUrl = "https://e7.pngegg.com/pngimages/178/28/png-clipart-computer-icons-money-bag-bank-cash-angle-hand-thumbnail.png";
        String bankImageUrl = "https://png.pngtree.com/png-clipart/20190614/original/pngtree-bank-icon-png-image_3697636.jpg";

        ImageView cashImageView = findViewById(R.id.cash_image_view);
        ImageView bankImageView = findViewById(R.id.bank_image_view);

        Glide.with(this).load(cashImageUrl).into(cashImageView);
        Glide.with(this).load(bankImageUrl).into(bankImageView);
    }

    public void onPaymentMethodSelected(View view) {
        int id = view.getId();
        Intent successIntent;

        if (id == R.id.button2) {
            successIntent = new Intent(PayMoneyActivity.this, BankTransferActivity.class);
            Toast.makeText(PayMoneyActivity.this, "คุณเลือก: โอนธนาคาร", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.button3) {
            successIntent = new Intent(PayMoneyActivity.this, OrderSuccessActivity.class);
            successIntent.putExtra("total_price", totalPrice);
            Toast.makeText(PayMoneyActivity.this, "คุณเลือก: จ่ายเงินสด", Toast.LENGTH_SHORT).show();
        } else {
            return; // ไม่ทำอะไรถ้าไม่ใช่ปุ่มที่ถูกต้อง
        }

        successIntent.putExtra("total_price", totalPrice);
        startActivity(successIntent);
        finish();
    }
}



