package com.example.jorge.basicos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DescricaoActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);


        Intent i = getIntent();
        ProdutosVO produto = (ProdutosVO) i.getParcelableExtra("produto_extra");

        TextView nome = (TextView) findViewById(R.id.nomeTxt);
        TextView descr = (TextView) findViewById(R.id.descrTxt);
        nome.setText(produto.getNomeProduto());
        descr.setText(produto.getDescricaoProduto());
    }


}
