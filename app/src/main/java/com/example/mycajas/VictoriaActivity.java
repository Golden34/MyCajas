package com.example.mycajas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    public void patras(View view) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (android.R.id.home == item.getItemId())
        {
            patras(null);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_del_dia, menu);

        return super.onCreateOptionsMenu(menu);

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
