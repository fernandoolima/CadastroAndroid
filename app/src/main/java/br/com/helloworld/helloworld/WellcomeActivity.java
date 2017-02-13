package br.com.helloworld.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

public class WellcomeActivity extends AppCompatActivity {

    //teste alteração git

    TextView lblNomeUser;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        lblNomeUser = (TextView) findViewById(R.id.lblNomeUser);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String nomeUsuario = sharedPreferences.getString("nomeUsuario", "");

        Intent intent = getIntent();

        /*Usuario usuarioLogado = (Usuario) intent.getSerializableExtra("usuarioLogado");

        String nomeUsuario = intent.getStringExtra("nomeUsuario");*/

        lblNomeUser.setText(nomeUsuario);
    }
}
