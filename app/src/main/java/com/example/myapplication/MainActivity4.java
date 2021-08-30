package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.CourseAdapter;
import com.example.myapplication.model.InfoCourse;
import com.example.myapplication.service.ServiceAPI;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import static com.example.myapplication.service.ServiceAPI.BASE_Service;
import static com.example.myapplication.others.ShowNotifyUser.dismissProgressDialog;
import static com.example.myapplication.others.ShowNotifyUser.showProgressDialog;

public class MainActivity4 extends AppCompatActivity {

    private Button btnGetData;
    private RecyclerView rlcCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnGetData = findViewById(R.id.btnGetData);
        rlcCourse = findViewById(R.id.rlcCourse);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog(MainActivity4.this, "Đang tải dữ liệu");
                getInfoDemo4();
            }
        });
    }

    private void getInfoDemo4() {

        ServiceAPI requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        new CompositeDisposable().add(requestInterface.GetDemo4()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(ArrayList<InfoCourse> infoCourses) {
        try {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rlcCourse.setLayoutManager(linearLayoutManager);
            CourseAdapter courseAdapter = new CourseAdapter(infoCourses, MainActivity4.this);
            rlcCourse.setAdapter(courseAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dismissProgressDialog();
    }

    private void handleError(Throwable error) {
        dismissProgressDialog();
        Toast.makeText(MainActivity4.this, "Lỗi", Toast.LENGTH_SHORT).show();
    }
}