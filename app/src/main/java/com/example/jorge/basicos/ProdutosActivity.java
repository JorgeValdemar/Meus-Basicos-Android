package com.example.jorge.basicos;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ProdutosActivity extends Activity {

    private ListView lista = null;
    public ArrayList<ProdutosVO> listaProdutos;

    private ProdutosDbHelper produtosDbHelper;

    /*
            new String[] { "Android List View",
                "Adapter implementation",
                "Android Example List View"
        };
     */
    private void getDatabaseProdutos() {
        SQLiteDatabase db = produtosDbHelper.getReadableDatabase();
        String table = "Produtos";
        String[] dados = new String[10];

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                "idProduto",
                "nomeProduto",
                "descricaoProduto",
                "imagemProduto",
                "precoProduto",
                "fabricanteProduto",
                "qualidadeProduto"
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder = "idProduto DESC";

        Cursor cursor = db.query(
                table,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        if (cursor != null) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                dados[i] = String.valueOf(cursor.getInt(0)) + " - " + cursor.getString(1);

                ProdutosVO pvo = new ProdutosVO();
                pvo.setIdProduto(cursor.getInt(0));
                pvo.setNomeProduto(cursor.getString(1));
                pvo.setDescricaoProduto(cursor.getString(2));
                pvo.setImagemProduto(cursor.getString(3));
                pvo.setPrecoProduto(cursor.getInt(4));
                pvo.setFabricanteProduto(cursor.getString(5));
                pvo.setQuantidadeProduto(cursor.getInt(6));
                listaProdutos.add(pvo);

                cursor.moveToNext();
            }
            cursor.close();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        produtosDbHelper = new ProdutosDbHelper(this);
        listaProdutos = new ArrayList<ProdutosVO>();
        lista = (ListView) findViewById(R.id.listView);

        this.getDatabaseProdutos();

        //ArrayAdapter<ProdutosVO> adapter = new ArrayAdapter<ProdutosVO>(this,
        //android.R.layout.simple_list_item_1, android.R.id.text1, listaProdutos);

        ProdutosAdapter adapter = new ProdutosAdapter(this, listaProdutos);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item value
                ProdutosVO produto = (ProdutosVO) parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "->"+String.valueOf(position) + "--"+produto.getNomeProduto(), Toast.LENGTH_LONG ).show();

                Intent produtosIntent = new Intent(getApplicationContext(), DescricaoActivity.class);
                produtosIntent.putExtra("produto_extra", produto);
                startActivity(produtosIntent);

            }
        });


    }




    public class ProdutosAdapter extends ArrayAdapter<ProdutosVO> {
        public ProdutosAdapter(Context context, ArrayList<ProdutosVO> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            ProdutosVO produto = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_lista, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.prodNome);
            TextView tvHome = (TextView) convertView.findViewById(R.id.prodValor);
            // Populate the data into the template view using the data object
            tvName.setText("Nome: " + produto.getNomeProduto());
            tvHome.setText("- Valor: " + String.valueOf(produto.getPrecoProduto()));
            // Return the completed view to render on screen
            return convertView;
        }
    }




}
