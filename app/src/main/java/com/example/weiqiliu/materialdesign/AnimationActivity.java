package com.example.weiqiliu.materialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.weiqiliu.materialdesign.domain.Box;
import com.example.weiqiliu.materialdesign.domain.Envelope;
import com.example.weiqiliu.materialdesign.service.GitHubService;
import com.example.weiqiliu.materialdesign.view.DrawView;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class AnimationActivity extends AppCompatActivity {
    private View view;
    private TextView text2;
    private TextView text1;
    private DrawView customView;
    private RelativeLayout layout;
    private int width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideswitch);
        initView();
        initRest();
    }

    private void initView() {
        view=(View) findViewById(R.id.animation);
        text2=(TextView) findViewById(R.id.text2);
        text1=(TextView) findViewById(R.id.text1);
        customView=(DrawView) findViewById(R.id.customView);

        layout=(RelativeLayout) findViewById(R.id.layout);

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.animate().translationX(v.getWidth()).setDuration(200).start();
            }
        });

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.animate().translationX(0).setDuration(100).start();
            }
        });

        Box<String> box=new Box<String>("123");
        box.getData();
    }

    private void initRest(){
//        Retrofit restAdapter = new Retrofit.Builder()
//                .baseUrl("http://api.justin.tv/api")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.nuuneoi.com/base/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        retrofit.Call<Envelope> call = service.loadRepo();
        call.enqueue(new retrofit.Callback<Envelope>() {
            @Override
            public void onResponse(Response<Envelope> response, Retrofit retrofit) {
                Log.e("111", "successful");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("111", "eooro");
            }
        });



    }

//    private OkHttpClient getClient(){
//        OkHttpClient client = new OkHttpClient();
//        client.interceptors().add(new Interceptor() {
//            @Override
//            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
//                com.squareup.okhttp.Response response = chain.proceed(chain.request());
//
//                Request request = chain.request();
//
//                long t1 = System.nanoTime();
//                logger.info(String.format("Sending request %s on %s%n%s",
//                        request.url(), chain.connection(), request.headers()));
//
//                com.squareup.okhttp.Response response = chain.proceed(request);
//
//                long t2 = System.nanoTime();
//                logger.info(String.format("Received response for %s in %.1fms%n%s",
//                        response.request().url(), (t2 - t1) / 1e6d, response.headers()));
//
//                return response;
//            }
//        });
//
//        return client;
//    }

//    class LoggingInterceptor implements Interceptor {
//        @Override public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//
//            long t1 = System.nanoTime();
//            logger.info(String.format("Sending request %s on %s%n%s",
//                    request.url(), chain.connection(), request.headers()));
//
//            com.squareup.okhttp.Response response = chain.proceed(request);
//
//            long t2 = System.nanoTime();
//            logger.info(String.format("Received response for %s in %.1fms%n%s",
//                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
//
//            return response;
//        }
//    }

}
