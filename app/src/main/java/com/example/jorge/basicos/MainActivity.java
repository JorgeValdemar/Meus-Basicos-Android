package com.example.jorge.basicos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    private String email = "teste@teste.com";
    private String senha = "123";

    private EditText emailText = null;
    private EditText senhaText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String emailLogado = sharedPref.getString("USER_LOGADO", "");

        if(!emailLogado.isEmpty()) {
            Intent produtosIntent = new Intent(this, ProdutosActivity.class);
            startActivity(produtosIntent);
        }
    }

    public void clickLogin(View v) {

        emailText = (EditText)findViewById(R.id.emailEditText);
        senhaText = (EditText)findViewById(R.id.senhaEditText);

        Toast.makeText(this, "E-mail "+ emailText.getText().toString(), Toast.LENGTH_LONG);
        if(email.equals(emailText.getText().toString()) && senha.equals(senhaText.getText().toString())) {

            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("USER_LOGADO", emailText.getText().toString());
            editor.commit();

            Intent produtosIntent = new Intent(this, ProdutosActivity.class);
            startActivity(produtosIntent);

        } else {
            Toast.makeText(this, "E-mail ou Senha inválidos", Toast.LENGTH_LONG).show();
        }


    }


}
