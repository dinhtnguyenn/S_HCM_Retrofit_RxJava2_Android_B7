package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.CourseAdapter;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.model.InfoCourse;
import com.example.myapplication.model.Product;
import com.example.myapplication.service.ServiceAPI;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import static com.example.myapplication.service.ServiceAPI.BASE_Service;
import static com.example.myapplication.others.ShowNotifyUser.dismissProgressDialog;
import static com.example.myapplication.others.ShowNotifyUser.showProgressDialog;

public class ProductActivity extends AppCompatActivity {

    private Button btnAddData;
    private RecyclerView rlcProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        btnAddData = findViewById(R.id.btnAddData);
        rlcProduct = findViewById(R.id.rlcProduct);

        showProgressDialog(ProductActivity.this, "Đang tải dữ liệu");
        getAllProduct();

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity.this, AddProductActivity.class));
            }
        });
    }

    private void getAllProduct() {

        ServiceAPI requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        new CompositeDisposable().add(requestInterface.GetAllProduct()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(ArrayList<Product> products) {
        try {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rlcProduct.setLayoutManager(linearLayoutManager);
            ProductAdapter productAdapter = new ProductAdapter(products, ProductActivity.this);
            rlcProduct.setAdapter(productAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dismissProgressDialog();
    }


    private void handleError(Throwable error) {
        dismissProgressDialog();
        Toast.makeText(ProductActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
    }
}