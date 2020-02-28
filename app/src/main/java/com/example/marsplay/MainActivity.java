package com.example.marsplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.marsplay.Adapters.RecyclerView_Adapter;
import com.example.marsplay.Models.doc;
import com.example.marsplay.Models.model;
import com.example.marsplay.Models.response;
import com.example.marsplay.interfaces.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView data_rv;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar_pb);
        data_rv = findViewById(R.id.data_rv);

        data_rv.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.VISIBLE);


    }

    public void onStart() {
        super.onStart();

        retrofitApiCall();

    }

    private void retrofitApiCall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<response> call = api.getResponse();

        call.enqueue(new Callback<response>() {
            @Override
            public void onResponse(Call<response> call, Response<response> response) {

                response response1 = response.body();
                model model = null;

                if (response1!=null){
                    model = response1.getModel();
                }

                if (model!=null) {

                    Log.d("response",model.getNumFound());
                    if (model.getDocs()==null){
                        Log.d("response","no docs");
                    }
                    ArrayList<String> abstracts_list = new ArrayList<>(model.getDocs().size());

                    for (int i = 0; i < model.getDocs().size(); i++) {

                        StringBuilder abstracts = new StringBuilder();
                        for (int j = 0 ; j<model.getDocs().get(i).getAbstracts().size();j++){
                            abstracts.append(model.getDocs().get(i).getAbstracts().get(j)).append(" ");
                        }
                        if (abstracts.length()>1) {
                            abstracts_list.add(abstracts.toString().trim());
                        }
                    }
                    setupRecyclerView(abstracts_list);
                }else{
                    Log.d("response",response.body().toString());
                }

            }
            @Override
            public void onFailure(Call<response> call, Throwable t) {
                Log.d("error",t.getMessage());
            }
        });
    }

    private void setupRecyclerView(ArrayList<String> abstracts_list){
        progressBar.setVisibility(View.INVISIBLE);
        RecyclerView_Adapter adapter = new RecyclerView_Adapter(abstracts_list);
        data_rv.setAdapter(adapter);
    }
}
