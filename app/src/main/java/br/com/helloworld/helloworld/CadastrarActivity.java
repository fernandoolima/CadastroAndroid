package br.com.helloworld.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class CadastrarActivity extends AppCompatActivity {

    EditText txtNome, txtEmail, txtSenha;
    Button btnLogar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        context = this;

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnLogar = (Button) findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, LoginActivity.class));
            }
        });
    }

    public void cadastrar(View view) {



        final String nome = txtNome.getText().toString();
        final String email = txtEmail.getText().toString();
        final String senha = txtSenha.getText().toString();


        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {

                String url= "http://10.107.144.74/TesteInicial/novoUsuario.php";

                HashMap<String, String> parametros = new HashMap<>();
                parametros.put("nome", nome);
                parametros.put("email", email);
                parametros.put("senha", senha);

                String resultado = Http.post(url, parametros);

                Log.d("cadastrar", resultado);

                return null;
            }

        }.execute();


        Toast.makeText(this, "Cadastro realizado com sucesso",
                Toast.LENGTH_SHORT).show();


    }



}
