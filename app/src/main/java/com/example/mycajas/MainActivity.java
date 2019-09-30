package com.example.mycajas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int iTotal = 0;
    private int numero_toques = 0;
    private int n_cajas_tocadas = 0;
    int color_negro = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color_negro = getResources().getColor(R.color.colorBlack);
    }
        // Con mascaras y OR
        public void cajaTocada2(View view) {
            Log.d("MiAPP", "Cata Tocada");
            LinearLayout ly = (LinearLayout)view;
            ly.setBackgroundColor(getResources().getColor(R.color.colorBlack));

            int bin = Integer.parseInt(ly.getTag().toString());
            iTotal = iTotal | bin;
            if (iTotal == 255) finish();
        }

        // Con clase Extendida de LinearLayout
        public void cajaTocada(View view) {
            Log.d("MIAPP", "Caja Tocada");
            numero_toques = numero_toques + 1;
            Log.d("MIAPP", "N toques = "+  numero_toques);
            MiLL myll = (MiLL)view;//casting
            if (!myll.isTocado())
            {
                Log.d("MIAPP", "Tocada por primera vez");
                myll.setBackgroundColor(color_negro);//pongo negra la caja
                myll.setTocado(true);
                myll.plusMiLL();
                if (myll.getTot()==8)
                {
                    Log.d("MIAPP", "Se han tocado todas");
                    finish();
                }

            } else {
                Log.d("MIAPP", "Ya se ha tocado la caja, no hago ná");
            }
        }

        // Con trabajo a traves de Drawable y variables generales
    public void cajaTocada3(View view) {
        Log.d("MIAPP", "Caja Tocada");
        numero_toques = numero_toques + 1;
        //numero_toques++;
        Log.d("MIAPP", "N toques = "+  numero_toques);
        LinearLayout linearLayout = (LinearLayout)view;//casting
        Drawable drawable = linearLayout.getBackground();//obtengo el fondo
        ColorDrawable colorDrawable = (ColorDrawable)drawable;//obtengo el color
        int color_negro = getResources().getColor(R.color.colorBlack);
        int color = colorDrawable.getColor();//obtengo el valor color numérico
        if (color != color_negro)
        {
            Log.d("MIAPP", "Tocada por primera vez");
            linearLayout.setBackgroundColor(color_negro);//pongo negra la caja
            n_cajas_tocadas++;
            if (n_cajas_tocadas==8)
            {
                Log.d("MIAPP", "Se han tocado todas");
                finish();
            }

        } else {
            Log.d("MIAPP", "Ya se ha tocado la caja, no hago ná");
        }

    }

}
