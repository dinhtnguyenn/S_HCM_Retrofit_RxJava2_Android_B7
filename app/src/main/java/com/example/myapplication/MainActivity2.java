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

import com.example.myapplication.adapter.UserAdapter;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserList;
import com.example.myapplication.service.ServiceAPI;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import static com.example.myapplication.service.ServiceAPI.BASE_Service;
import static com.example.myapplication.others.ShowNotifyUser.dismissProgressDialog;
import static com.example.myapplication.others.ShowNotifyUser.showProgressDialog;

public class MainActivity2 extends AppCompatActivity {

    private Button btnGetData;
    private RecyclerView rlcUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rlcUser = findViewById(R.id.rlcUser);
        btnGetData = findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog(MainActivity2.this, "Đang tải dữ liệu");
                getInfoDemo2();
            }
        });

    }

    private void getInfoDemo2() {

        ServiceAPI requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        new CompositeDisposable().add(requestInterface.GetDemo2()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(UserList userList) {
        try {
            ArrayList<User> _alUser = userList.getUserList();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rlcUser.setLayoutManager(linearLayoutManager);
            UserAdapter userAdapter = new UserAdapter(_alUser, MainActivity2.this);
            rlcUser.setAdapter(userAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dismissProgressDialog();
    }

    private void handleError(Throwable error) {
        dismissProgressDialog();
        Toast.makeText(MainActivity2.this, "Lỗi", Toast.LENGTH_SHORT).show();
    }
}