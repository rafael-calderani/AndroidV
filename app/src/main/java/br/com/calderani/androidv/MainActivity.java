package br.com.calderani.androidv;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.calderani.androidv.adapter.AndroidAdapter;
import br.com.calderani.androidv.api.APIUtils;
import br.com.calderani.androidv.api.AndroidAPI;
import br.com.calderani.androidv.model.Android;
import br.com.calderani.androidv.model.AndroidResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvAndroids;
    private AndroidAdapter androidAdapter;
    private AndroidAPI androidAPI;

    /*
    Objetos para requições Nativas
     JSONObject
     HTTP
     AsyncTask
     Exemplo: Github -> heiderlopes -> RecyclerViewComAsyncTask
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Carregar com as versões do Androido o_O

        androidAdapter = new AndroidAdapter(new ArrayList<Android>());

        rvAndroids = (RecyclerView) findViewById(R.id.rvAndroids);
        rvAndroids.setLayoutManager(new LinearLayoutManager(this));
        rvAndroids.setAdapter(androidAdapter);
        rvAndroids.setHasFixedSize(true);
        /*rvAndroids.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));*/
        carregarAndroids();
    }
    private void carregarAndroids(){
        androidAPI = APIUtils.getAndroidAPIVersion();
        androidAPI.getVersoes().enqueue(new Callback<AndroidResponse>() {
            @Override
            public void onResponse(Call<AndroidResponse> call, Response<AndroidResponse> response) {
                if(response.isSuccessful()) { // Sucesso
                    androidAdapter.update(response
                            .body()
                            .getAndroidList()
                    );
                }
            }

            @Override
            public void onFailure(Call<AndroidResponse> call, Throwable t) {
                // Faio
            }
        });
    }
}
