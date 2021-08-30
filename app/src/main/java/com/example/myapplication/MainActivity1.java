package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Info;
import com.example.myapplication.service.ServiceAPI;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static com.example.myapplication.service.ServiceAPI.BASE_Service;
import static com.example.myapplication.others.ShowNotifyUser.dismissProgressDialog;
import static com.example.myapplication.others.ShowNotifyUser.showProgressDialog;

public class MainActivity1 extends AppCompatActivity {

    private Button btnGetData;
    private TextView txtCourse, txtPlace, txtFanpage, txtYoutube, txtGame;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btnGetData = findViewById(R.id.btnGetData);
        txtCourse = findViewById(R.id.txtCourse);
        txtPlace = findViewById(R.id.txtPlace);
        txtFanpage = findViewById(R.id.txtFanpage);
        txtYoutube = findViewById(R.id.txtYoutube);
        txtGame = findViewById(R.id.txtGame);
        ivLogo = findViewById(R.id.ivLogo);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog(MainActivity1.this, "Đang tải dữ liệu");
                getInfoDemo1();
            }
        });


    }

    private void getInfoDemo1() {
        ServiceAPI requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        new CompositeDisposable().add(requestInterface.GetDemo1()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(Info info) {
        try {
            txtCourse.setText(info.getCourse());
            txtPlace.setText(info.getPlace());
            txtFanpage.setText(info.getFanpage());
            txtYoutube.setText(info.getYoutube());
            txtGame.setText(info.getGames());

            Glide.with(MainActivity1.this)
                    .load(info.getLogo())
                    .into(ivLogo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        dismissProgressDialog();
    }

    private void handleError(Throwable throwable) {
        dismissProgressDialog();
        Toast.makeText(MainActivity1.this, "Lỗi", Toast.LENGTH_SHORT).show();
    }

}