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
import android.widget.TextView;

import com.example.myapplication.model.ModelData3;
import com.example.myapplication.service.ServiceAPI;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static com.example.myapplication.service.ServiceAPI.BASE_Service;
import static com.example.myapplication.others.ShowNotifyUser.dismissProgressDialog;
import static com.example.myapplication.others.ShowNotifyUser.showProgressDialog;

public class MainActivity3 extends AppCompatActivity {

    private Button btnGetData;
    private TextView txtVN, txtEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnGetData = findViewById(R.id.btnGetData);
        txtVN = findViewById(R.id.txtVN);
        txtEN = findViewById(R.id.txtEN);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog(MainActivity3.this, "Đang tải dữ liệu");
                getDataDemo3();
            }
        });
    }

    private void getDataDemo3() {
        ServiceAPI requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        new CompositeDisposable().add(requestInterface.GetDemo3()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(ModelData3 modelData3) {
        String vn = modelData3.getLanguage().getVn().getName();
        txtVN.setText(vn);

        String en = modelData3.getLanguage().getEn().getName();
        txtEN.setText(en);

        dismissProgressDialog();
    }

    private void handleError(Throwable throwable) {
        dismissProgressDialog();
    }


}