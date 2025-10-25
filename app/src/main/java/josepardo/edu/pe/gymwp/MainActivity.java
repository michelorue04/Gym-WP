package josepardo.edu.pe.gymwp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import josepardo.edu.pe.gymwp.databinding.ActivityMainBinding; // Necesitarás habilitar ViewBinding

public class MainActivity extends AppCompatActivity { // Debe extender AppCompatActivity

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Infla (crea) el layout y lo establece como la vista de esta actividad
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el BottomNavigationView
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Configura el NavController para manejar la navegación entre fragmentos
        // Pasa cada ID del menú como un conjunto de destinos de nivel superior.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.login, R.id.inicio01, R.id.registra) // Añade aquí los IDs de tu menú
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); // Descomenta si tienes una ActionBar
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}