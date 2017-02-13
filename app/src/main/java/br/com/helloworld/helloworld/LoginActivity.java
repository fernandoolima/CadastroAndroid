package br.com.helloworld.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    EditText txtLogin, txtSenhaLogin;
    Button btnEntrar, btnCadastrar;

    SharedPreferences sharedPreferences;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenhaLogin = (EditText) findViewById(R.id.txtSenhaLogin);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);



        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String login = txtLogin.getText().toString();
                final String senha = txtSenhaLogin.getText().toString();

                new AsyncTask<Void, Void, Void>(){

                    @Override
                    protected Void doInBackground(Void... params) {

                        String url = "http://10.107.144.74/TesteInicial/Login.php";

                        HashMap<String, String> parametros = new HashMap<>();
                        parametros.put("email", login);
                        parametros.put("senha", senha);

                        String retorno = Http.post(url, parametros);

                        Log.d("efetuarLogin", retorno);

                        Gson gson = new Gson();

                        Usuario usuarioLogado = gson.fromJson(retorno, Usuario.class);

                        Log.d("efetuarLogin", usuarioLogado.getNome());

                        //Sessao.usuarioLogado = usuarioLogado;

                        sharedPreferences.edit().putString("nomeUsuario", usuarioLogado.getNome()).apply();

                        Intent intent = new Intent(context, WellcomeActivity.class);

                        /*intent.putExtra("nomeUsuario", usuarioLogado.getNome());

                        intent.putExtra("usuarioLogado", usuarioLogado);*/

                        startActivity(intent);

                        return null;
                    }
                }.execute();


            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, CadastrarActivity.class));
            }
        });
    }
}
