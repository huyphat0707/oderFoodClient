package com.example.finalandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.finalandroid.configs.API;
import com.example.finalandroid.configs.RetrofitClient;
import com.example.finalandroid.controllers.ProductAdapters;
import com.example.finalandroid.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public static List<Product> productList = new ArrayList<>();
    ProductAdapters productAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
    }

    private void setData() {

        //lay tu sever
        API api = RetrofitClient.getClient().create(API.class);
        api.getProduct().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    productList = response.body();
                    if (productList != null) {
                        productAdapters = new ProductAdapters(productList, MainActivity.this);
                        recyclerView.setAdapter(productAdapters);
                    } else {
                        Log.d("Error ", "aaa");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                //xu ly khi khong nhan du lieu
                Log.d("Error", "lôiiiiiiii: " + t.getMessage());
            }
        });

    }

    private void initView() {
        recyclerView = findViewById(R.id.rc_final);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);



    }

}
