package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.model.Meat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Meat> meatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView storeName = findViewById(R.id.store_name);
        storeName.setText("ร้านเนื้อคับ");

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        meatList = new ArrayList<>();
        populateInitialMeatList();

        mAdapter = new MyAdapter(meatList, this);
        recyclerView.setAdapter(mAdapter);
    }

    private void populateInitialMeatList() {
        Meat meat1 = new Meat();
        meat1.setMeat_name("เนื้อวัว");
        meat1.setMeat_image("https://www.menafood.co.th/sites/storage/files/styles/550x550/typmedia/olc/80010063/61dea3f20111e-%E0%B9%82%E0%B8%A3%E0%B8%87%E0%B8%87%E0%B8%B2%E0%B8%99%E0%B8%9C%E0%B8%A5%E0%B8%B4%E0%B8%95%E0%B9%80%E0%B8%99%E0%B8%B7%E0%B9%89%E0%B8%AD%E0%B8%A7%E0%B8%B1%E0%B8%A7+%E0%B8%9B%E0%B8%97%E0%B8%B8%E0%B8%A1%E0%B8%B2%E0%B8%99%E0%B8%B5.jpg?itok=66d9780d");
        meat1.setMeat_type("เนื้อสะโพก");
        meat1.setMeat_origin("USA");
        meat1.setMeat_price(80);
        meatList.add(meat1);

        Meat meat2 = new Meat();
        meat2.setMeat_name("เนื้อหมู");
        meat2.setMeat_image("https://st.bigc-cs.com/cdn-cgi/image/format=webp,quality=90/public/media/catalog/product/43/02/0211343/0211343_1.jpg");
        meat2.setMeat_type("เนื้อสันใน");
        meat2.setMeat_origin("Thailand");
        meat2.setMeat_price(50);
        meatList.add(meat2);

        Meat meat3 = new Meat();
        meat3.setMeat_name("เนื้อไก่");
        meat3.setMeat_image("https://cdn8.devgodigit.net/wp-content/uploads/2021/09/30200441/051471239_F.jpg");
        meat3.setMeat_type("เนื้อสะโพก");
        meat3.setMeat_origin("Thailand");
        meat3.setMeat_price(60);
        meatList.add(meat3);

        Meat meat4 = new Meat();
        meat4.setMeat_name("เนื้อเป็ด");
        meat4.setMeat_image("https://cdn8.devgodigit.net/wp-content/uploads/2023/03/21103914/51432586_F.jpg");
        meat4.setMeat_type("เนื้อน่อง");
        meat4.setMeat_origin("China");
        meat4.setMeat_price(40);
        meatList.add(meat4);

        Meat meat5 = new Meat();
        meat5.setMeat_name("เนื้อไก่งวง");
        meat5.setMeat_image("https://organic-village.co.th/wp-content/uploads/2021/11/2-Turkey-1-1200x1200.jpg");
        meat5.setMeat_type("เนื้อทั้งตัว");
        meat5.setMeat_origin("China");
        meat5.setMeat_price(90);
        meatList.add(meat5);
    }
}
