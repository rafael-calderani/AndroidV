package br.com.calderani.androidv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Spinner spAndroidVersion;
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
        spAndroidVersion = (Spinner) findViewById(R.id.spAndroidVersions);

        // TODO: Carregar Spinner com as versões do Androido o_O
    }
}
