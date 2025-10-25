// Archivo: login.java
package josepardo.edu.pe.gymwp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
// (Importa también TextInputEditText, etc., si necesitas leer los valores)
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import josepardo.edu.pe.gymwp.R; // Asegúrate de importar tu R

public class login extends Fragment {

    // Declaramos los botones con los IDs de tu XML
    Button btnLogin;
    Button btnCrearCuenta;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla el layout que proporcionaste
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- Navegación a inicio01 (Iniciar Sesión) ---

        // 1. Encuentra el botón de Iniciar Sesión por su ID correcto
        btnLogin = view.findViewById(R.id.btnLogin); // ID Corregido

        btnLogin.setOnClickListener(v -> {

            // --- ¡IMPORTANTE! ---
            // Aquí deberías añadir tu lógica para validar el email y la contraseña
            // que el usuario escribió.
            // String email = view.findViewById(R.id.editTextUser).getText().toString();
            // String password = view.findViewById(R.id.editTextPassword).getText().toString();
            //
            // if (validar(email, password)) { ... }
            // --- Fin de la validación ---

            // Si la validación es exitosa, navega a la siguiente pantalla
            Navigation.findNavController(v).navigate(R.id.action_login_to_inicio01);
        });


        // --- Navegación a registra (Crear Cuenta) ---

        // 2. Encuentra el botón de Crear Cuenta por su ID correcto
        btnCrearCuenta = view.findViewById(R.id.btnCrearCuenta); // ID Corregido

        btnCrearCuenta.setOnClickListener(v -> {
            // Llama a la acción para ir a registra
            Navigation.findNavController(v).navigate(R.id.action_login_to_registra);
        });
    }
}