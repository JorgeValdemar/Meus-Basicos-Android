package com.example.jorge.basicos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jorge on 29/09/2015.
 */
public class ProdutosDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "basicos.db";

    public ProdutosDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(
                "CREATE TABLE IF NOT EXISTS Produtos ( idProduto INTEGER PRIMARY KEY, nomeProduto VARCHAR(50), descricaoProduto VARCHAR(200), imagemProduto VARCHAR(200), precoProduto INTEGER, fabricanteProduto VARCHAR(40), qualidadeProduto INTEGER)"
            );

            db.execSQL(
                "INSERT INTO Produtos (nomeProduto, descricaoProduto, imagemProduto, precoProduto, fabricanteProduto, qualidadeProduto) VALUES " +
                        "('Produto 1', 'o um', 'img1.jpg', 199, 'Sony', 8)," +
                        "('Produto 2', 'o dois', 'img2.jpg', 2346, 'Intel', 4)," +
                        "('Produto 3', 'o tres', 'img3.jpg', 23562, 'Microsoft', 88)," +
                        "('Produto 4', 'o quatro', 'img4.jpg', 178, 'Apple', 38)," +
                        "('Produto 5', 'o cinco', 'img5.jpg', 1112, 'Sony', 28)," +
                        "('Produto 6', 'o seis', 'img6.jpg', 10, 'Intel', 54)," +
                        "('Produto 7', 'o sete', 'img7.jpg', 439, 'Corp', 9)," +
                        "('Produto 8', 'o oito', 'img8.jpg', 214, 'Teste', 11)," +
                        "('Produto 9', 'o nove', 'img9.jpg', 20, 'Sony', 30)," +
                        "('Produto 10', 'o dez', 'img10.jpg', 800, 'Sony', 50)"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("TRUNCATE TABLE basicos.Produtos");
        onCreate(db);
    }
}
