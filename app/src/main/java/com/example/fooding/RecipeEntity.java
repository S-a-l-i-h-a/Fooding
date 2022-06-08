package com.example.fooding;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "recipes")
public class RecipeEntity{

        @PrimaryKey(autoGenerate = true)
        Integer id;

        @ColumnInfo(name = "keyProduct")
        String keyProduct;

        @ColumnInfo(name = "diabetes")
        String diabetes;

        @ColumnInfo(name = "vegan")
        String vegan;

        @ColumnInfo(name = "vegetarian")
        String vegetarian;

        @ColumnInfo(name = "pescatarian")
        String pescatarian;

        @ColumnInfo(name = "glutenfree")
        String glutenfree;

        @ColumnInfo(name = "dairyfree")
        String dairyfree;

    public RecipeEntity(String keyProduct, String diabetes, String vegan, String vegetarian, String pescatarian, String glutenfree, String dairyfree) {
        this.keyProduct = keyProduct;
        this.diabetes = diabetes;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.pescatarian = pescatarian;
        this.glutenfree = glutenfree;
        this.dairyfree = dairyfree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyProduct() {
        return keyProduct;
    }

    public void setKeyProduct(String keyProduct) {
        this.keyProduct = keyProduct;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getPescatarian() {
        return pescatarian;
    }

    public void setPescatarian(String pescatarian) {
        this.pescatarian = pescatarian;
    }

    public String getGlutenfree() {
        return glutenfree;
    }

    public void setGlutenfree(String glutenfree) {
        this.glutenfree = glutenfree;
    }

    public String getDairyfree() {
        return dairyfree;
    }

    public void setDairyfree(String dairyfree) {
        this.dairyfree = dairyfree;
    }
}

