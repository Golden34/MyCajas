package com.example.mycajas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class VictoriaActivity extends AppCompatActivity {

    private AnimationDrawable ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoria);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imagenView = findViewById(R.id.carrusel);
        imagenView.setBackgroundResource(R.drawable.secuencia_victoria);
        this.ad = (AnimationDrawable) imagenView.getBackground();
        this.ad.start();

    }

    // Inflado del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_del_dia, menu);

        return super.onCreateOptionsMenu(menu);

    }

    //Chequeo del elemento tocado del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (android.R.id.home == item.getItemId())
        {
            patras(null);
        }

        switch (item.getItemId())
        {
            case android.R.id.home:
                Log.d("MIAPP", "Para aTRás  <--");
                break;
            case R.id.salir:
                Log.d("MIAPP", "Menu salir");
                break;
            case R.id.comparar:
                Log.d("MIAPP", "Menu comparar");
                break;
            case R.id.blabla:
                Log.d("MIAPP", "Menu blabla");

                // Ir a la otra actividad via Intent
                finish();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void patras(View view) {
        finish();
    }

    /*
        if (!PreferencesUsuario.getPrefSaltarAnim(this)) //si está activada la animación
        {

            Log.d("MIAPP", "Preparamos animación");
            //1 obtengo la imagen
            ImageView imagenView = findViewById(R.id.carrusel);
            //2 cargo la animacion
            imagenView.setBackgroundResource(R.drawable.introduccion);
            this.ad = (AnimationDrawable) imagenView.getBackground();
            this.ad.start();
            Log.d(Constantes.TAG_APP, "Animación lanzada");
        } else {
            Log.d(Constantes.TAG_APP, "Animación desactivada");
            Intent intent = null;

            if (PreferencesUsuario.getPrefSaltarInicio(this))
            {
                Log.d(Constantes.TAG_APP, "Inicio desactivada. A mapas");
                intent = new Intent(this , MapaActivity.class);

            } else {
                Log.d(Constantes.TAG_APP, "Inicio activado. A inicio");
                intent = new Intent(this , InicioActivity.class);
            }
            startActivity(intent);
            finish();
        }
    }

    public void saltar (View v ) {

        Log.d(Constantes.TAG_APP, "Tocó saltar");
        this.ad.stop();
        Log.d(Constantes.TAG_APP, "Animación detenida");
        Intent intent = null;
        boolean quiere_saltar = PreferencesUsuario.getPrefSaltarInicio(this);
        if (quiere_saltar)
        {
            intent = new Intent(this , MapaActivity.class);
        }
        else {
            intent = new Intent(this , InicioActivity.class);
        }

        startActivity(intent);//ejecuto el intent (salta a la accion)
        finish();// finaliza la actividad (introduccion)
    }
    */
}
