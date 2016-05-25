package org.coursera.petagram;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by rodomualdo on 24/05/2016.
 */
public class Pet {

    private int foto;
    private String name;
    private int rate;

    public Pet(int foto, String name, int rate){
        this.foto = foto;
        this.name = name;
        this.rate = rate;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }



}
