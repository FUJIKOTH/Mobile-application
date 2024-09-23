package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class BankTransferActivity extends AppCompatActivity {

    private TextView totalPriceText;
    private ImageView bankImageView;
    private Button completePaymentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_transfer);

        totalPriceText = findViewById(R.id.total_price_text);
        bankImageView = findViewById(R.id.bank_image_view);
        completePaymentButton = findViewById(R.id.complete_payment_button);

        // รับค่า total_price จาก Intent
        Intent intent = getIntent();
        double totalPrice = intent.getDoubleExtra("total_price", 0.0);
        totalPriceText.setText(String.format("ยอดรวมทั้งหมด: ฿%.2f", totalPrice));

        // โหลดรูปภาพจาก URL
        String bankImageUrl = "https://www.scb.co.th/content/media/personal-banking/digital-banking/scb-easy/how-to/qr-code/icon-how-to-qr.png";
        Glide.with(this).load(bankImageUrl).into(bankImageView);

        // ตั้งค่าการคลิกสำหรับปุ่มชำระเสร็จสิ้น
        completePaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent successIntent = new Intent(BankTransferActivity.this, OrderSuccessActivity.class);
                successIntent.putExtra("total_price", totalPrice);
                startActivity(successIntent);
                finish();
            }
        });
    }
}
