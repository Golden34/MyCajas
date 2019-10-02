package com.example.mycajas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int iTotal = 0;
    private int numero_toques = 0;
    private int n_cajas_tocadas = 0;
    private int color_negro = 0;
    private long tini = 0;
    private Boolean tocable = false;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color_negro = getResources().getColor(R.color.colorBlack);

        ViewGroup elemento_padre = findViewById((R.id.caja_raiz));
        List<View> l_vistas = findViewsByType(elemento_padre, TextView.class);
        Log.d("MIAPP", "El num de TextViews es  " + l_vistas.size());

        ViewGroup vactual = null;
        TextView vistahija = null;

        //for each
        //for (View v : l_vistas)  ((TextView)v).setText(String.valueOf((int)(Math.random()*100+1)));

        for (int i = 0; i<l_vistas.size(); i++)
        {
            double nAle = Math.random()*10+1;
            int iALe = (int)nAle;
            total += iALe;
            String sAle = "" + iALe;
            vistahija = (TextView) l_vistas.get(i);
            vistahija.setText(sAle);
            Log.d("MIAPP", "Mostrando " + vistahija.getClass().getCanonicalName());
        }
        tini = System.currentTimeMillis() - tini;
        Toast.makeText(this, "Suma:  " + total, Toast.LENGTH_LONG).show();

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
            if (tocable) {
                Log.d("MIAPP", "Caja Tocada");
                numero_toques = numero_toques + 1;
                Log.d("MIAPP", "N toques = " + numero_toques);
                MiLL myll = (MiLL) view;//casting
                if (!myll.isTocado()) {
                    Log.d("MIAPP", "Tocada por primera vez");
                    myll.setBackgroundColor(color_negro);//pongo negra la caja
                    myll.setTocado(true);
                    myll.plusMiLL();
                    if (myll.getTot() == 8) {
                        Log.d("MIAPP", "Se han tocado todas");
                        tini = System.currentTimeMillis() - tini;
                        Toast t = Toast.makeText(this, "Duración:  " + tini + "  milisegundos", Toast.LENGTH_LONG); //.show();
                        t.show();
                        finish();
                    }

                } else {
                    Log.d("MIAPP", "Ya se ha tocado la caja, no hago ná");
                }
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

    public void empezar(View view) {
        tini = System.currentTimeMillis();
        tocable = true;
        view.setVisibility(View.GONE);
        Toast t = Toast.makeText(this, "Juego Empezado", Toast.LENGTH_SHORT); //.show();
        t.show();
    }

    /**
     *   private void mostrarLayout(View vista)
     *     {
     *         Log.d(getClass().getCanonicalName(), vista.getClass().getCanonicalName());
     *
     *         if (vista instanceof ViewGroup)
     *         {
     *             ViewGroup viewGroup = (ViewGroup) vista;
     *
     *             for (int i = 0; i<viewGroup.getChildCount(); i++)
     *             {
     *                 View vistahija = viewGroup.getChildAt(i);
     *                 mostrarLayout(vistahija);
     *
     *             }
     *         }
     *     }
     */

    private List<View> findViewsByType (@NonNull ViewGroup vista_raiz, Class tipo_buscado)
    {
        List<View> lvistas = null;
        int nhijos = 0;
        ViewGroup vactual = null;
        View vistahija = null;

        List<ViewGroup> lista_vistas = new ArrayList<ViewGroup>();
        lista_vistas.add(vista_raiz);
        lvistas = new ArrayList<View>();

        for (int i = 0; i<lista_vistas.size(); i++)
        {
            vactual = lista_vistas.get(i);
            Log.d("MIAPP", "Mostrando " + vactual.getClass().getCanonicalName());
            nhijos = vactual.getChildCount();
            for (int j = 0;j<nhijos;j++ )
            {
                vistahija = vactual.getChildAt(j);
                if (tipo_buscado.isAssignableFrom(vistahija.getClass()))
                {
                    lvistas.add(vistahija);
                }
                if (vistahija instanceof  ViewGroup)
                {
                    lista_vistas.add((ViewGroup)vistahija);
                }
                else
                {
                    Log.d("MIAPP", "Mostrando " + vistahija.getClass().getCanonicalName());
                }
            }
        }
        return lvistas;
    }

    public void comprobarSuma(View view) {
        ViewGroup elemento_padre = findViewById((R.id.caja_inferior));
        List<View> l_vistas = findViewsByType(elemento_padre, EditText.class);
        Log.d("MIAPP", "El num de EditText es  " + l_vistas.size());
        if (l_vistas.size() == 1) {
            String sTotal = String.valueOf(total);
            if (sTotal.equals(((EditText)l_vistas.get(0)).getText().toString())){
                long tfin = System.currentTimeMillis() - tini;
                tini = System.currentTimeMillis();
                Toast.makeText(this, "ACERTADO!!:  " + tfin/1000 + " segundos", Toast.LENGTH_SHORT).show();
                MediaPlayer mp = new MediaPlayer();
                mp = MediaPlayer.create(this, R.raw.morsa);
                mp.setLooping(false);
                mp.setVolume(100, 100);
                mp.start();
                //finish();

                // Ir a la otra actividad via Intent
                Intent intent = new Intent(this,VictoriaActivity.class);
                startActivity(intent);
            }
            else Toast.makeText(this, "NO! Sigue probando", Toast.LENGTH_SHORT).show();
        }
    }
}

/*
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
                android:oneshot="false">
    <item android:drawable="@drawable/rivas_1" android:duration="1700" />
    <item android:drawable="@drawable/rivas_2" android:duration="1700" />
    <item android:drawable="@drawable/rivas_3" android:duration="1700" />
    <item android:drawable="@drawable/rivas_4" android:duration="1700" />
    <item android:drawable="@drawable/rivas_5" android:duration="2000" />
</animation-list>
 */