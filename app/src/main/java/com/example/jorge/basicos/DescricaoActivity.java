package com.example.jorge.basicos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DescricaoActivity extends Activity {

    private ProdutosVO produto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        produto = ProdutosVO.getInstance();

        TextView nome = (TextView) findViewById(R.id.nomeTxt);
        TextView descr = (TextView) findViewById(R.id.descrTxt);
        nome.setText(produto.getNomeProduto());
        descr.setText(produto.getDescricaoProduto());
    }


}
