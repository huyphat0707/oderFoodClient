package com.example.finalandroid.controllers;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.finalandroid.EditActivity;
import com.example.finalandroid.R;
import com.example.finalandroid.models.Product;
import java.util.ArrayList;
import java.util.List;
import static com.example.finalandroid.configs.Constants.BASE_URL;
public class ProductAdapters extends RecyclerView.Adapter<ProductAdapters.RecyclerViewHolder> {

    private List<Product> data = new ArrayList<>();
    private Context context;


    public ProductAdapters(List<Product> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_test, parent, false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Product productModel = this.data.get(position);
        holder.tvTenProduct.setText(productModel.getTenSp());
        holder.tvGiaProduct.setText(productModel.getGiaSp());
        Glide.
                with(context)
                .load(BASE_URL+"upload/"+productModel.getImages())
                .override(100,100)
                .fitCenter()
                .into(holder.img);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("id", data.get(position).getId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTenProduct;
        TextView tvGiaProduct;
        CardView item;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvTenProduct = itemView.findViewById(R.id.tvTenProduct);
            tvGiaProduct = itemView.findViewById(R.id.tvGiaProduct);
            item = itemView.findViewById(R.id.item);


        }
    }


}