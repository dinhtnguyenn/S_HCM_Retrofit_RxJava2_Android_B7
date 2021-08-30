package com.example.myapplication.service;

import com.example.myapplication.model.Info;
import com.example.myapplication.model.InfoCourse;
import com.example.myapplication.model.Language;
import com.example.myapplication.model.Message;
import com.example.myapplication.model.ModelData3;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserList;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceAPI {
    String BASE_Service = "https://hoccungminh.dinhnt.com/";

    @GET("demo1.json")
    Observable<Info> GetDemo1();

    @GET("demo2.json")
    Observable<UserList> GetDemo2();

    @GET("demo3.json")
    Observable<ModelData3> GetDemo3();

    @GET("demo4.json")
    Observable<ArrayList<InfoCourse>> GetDemo4();

    @GET("demo5.json")
    Observable<ArrayList<InfoCourse>> GetDemo5();


    //áp dụng thực tế
    @GET("api/all-product")
    Observable<ArrayList<Product>> GetAllProduct();

    @GET("api/product-detail")
    Observable<ArrayList<Product>> GetDetailProduct(@Query("id") int id);

    @POST("api/add-product")
    Observable<Message> AddProduct(@Body Product product);
}
