package com.example.jorge.basicos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jorge on 29/09/2015.
 */
public class ProdutosVO {
    private int mData;
    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private String imagemProduto;
    private int precoProduto;
    private String fabricanteProduto;
    private int quantidadeProduto;

    private static ProdutosVO _instance = null;

    // maravilhoso singleton
    public static ProdutosVO getInstance() {
        if(_instance == null) {
            _instance = new ProdutosVO();
        }
        return _instance;
    }

    public ProdutosVO() {
    }
    
    public ProdutosVO(Parcel in) {
        mData = in.readInt();
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public int getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(int precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getFabricanteProduto() {
        return fabricanteProduto;
    }

    public void setFabricanteProduto(String fabricanteProduto) {
        this.fabricanteProduto = fabricanteProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }


}
