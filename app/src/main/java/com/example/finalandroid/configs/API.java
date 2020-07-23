package com.example.finalandroid.configs;

import com.example.finalandroid.models.Product;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface API {
    //http://192.168.1.29:3000/api/product
    //http://192.168.43.96:3000/api/product
    //http://192.168.1.107:3000/api/product
    @GET("api/product")
    Call<List<Product>> getProduct();
}
