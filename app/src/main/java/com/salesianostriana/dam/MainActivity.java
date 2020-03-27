package com.salesianostriana.dam;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.salesianostriana.dam.commons.Constants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements EstablecimientoListener{
    EstablecimientoViewModel establecimientoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        establecimientoViewModel = new ViewModelProvider(this).get(EstablecimientoViewModel.class);

        establecimientoViewModel.getIdEstablecimientoSeleccionado().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer idEstablecimiento) {
                if(idEstablecimiento != null) {
                    Intent i = new Intent(MainActivity.this, DetalleEstablecimientoActivity.class);
                    i.putExtra(Constants.ID_ESTABLECIMIENTO, idEstablecimiento);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onClickListener(Establecimiento e) {

    }
}
