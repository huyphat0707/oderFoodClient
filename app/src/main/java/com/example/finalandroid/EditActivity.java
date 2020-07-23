package com.example.finalandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.example.finalandroid.configs.API;
import com.example.finalandroid.configs.RetrofitClient;
import com.example.finalandroid.controllers.ProductAdapters;
import com.example.finalandroid.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.finalandroid.configs.Constants.BASE_URL;

public class EditActivity extends AppCompatActivity {
    ImageView img;
    Product product = new Product();
    TextView txtLoai, txtTen, txtMota, txtNgay,txtGia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);



        Intent intent = getIntent();
        final String idProduct = intent.getStringExtra("id");


        txtLoai = findViewById(R.id.loaisp);
        txtTen = findViewById(R.id.tenSp);
        txtMota = findViewById(R.id.moTa);
        txtNgay = findViewById(R.id.ngay);
        txtGia = findViewById(R.id.gia);
        img = findViewById(R.id.image);

        for (Product productModel : MainActivity.productList) {
          if (productModel.getId().equals(idProduct)) {
                txtLoai.setText(productModel.getLoaiSp());
                txtTen.setText(productModel.getTenSp());
                txtNgay.setText(productModel.getNgayThemSp());
                txtMota.setText(productModel.getMoTaSp());
                txtGia.setText(productModel.getGiaSp());
                Glide.
                      with(this)
                      .load(BASE_URL+"upload/"+productModel.getImages())
                      .override(100,100)
                      .fitCenter()
                      .into(img);
           }
        }
    }
}
