package josepardo.edu.pe.gymwp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import josepardo.edu.pe.gymwp.R;

// NOTA: Se han eliminado los imports de Google y Facebook ya que no se usarán activamente por ahora.
// Se pueden volver a añadir cuando actives esas funciones.

public class login extends Fragment {

    // Vistas de la UI
    private EditText editTextUser, editTextPassword;
    private Button btnLogin, btnCrearCuenta;
    private ImageButton btnGoogle, btnFacebook, btnGitHub;
    private CheckBox checkBoxRememberMe;
    private TextView textViewForgotPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Se crea la vista del fragmento a partir del archivo XML.
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Enlazar las vistas con sus IDs del XML
        initializeViews(view);

        // 2. Configurar los listeners para los botones
        setupClickListeners();
    }

    /**
     * Inicializa todas las vistas del fragmento.
     */
    private void initializeViews(View view) {
        editTextUser = view.findViewById(R.id.editTextUser);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnCrearCuenta = view.findViewById(R.id.btnCrearCuenta);
        btnGoogle = view.findViewById(R.id.btnGoogle);
        btnFacebook = view.findViewById(R.id.btnFacebook);
        btnGitHub = view.findViewById(R.id.btnGitHub);
        checkBoxRememberMe = view.findViewById(R.id.checkBoxRememberMe);
        textViewForgotPassword = view.findViewById(R.id.textViewForgotPassword);
    }

    /**
     * Configura todos los OnClickListeners para los elementos interactivos.
     */
    private void setupClickListeners() {
        // --- Listener para el botón de Iniciar Sesión (tradicional) ---
        // ESTA FUNCIÓN ESTÁ ACTIVA
        btnLogin.setOnClickListener(v -> handleTraditionalLogin());

        // --- Listener para el botón de Crear Cuenta ---
        // ESTA FUNCIÓN ESTÁ ACTIVA
        btnCrearCuenta.setOnClickListener(v -> {
            // Navega hacia el fragmento de registro
            NavHostFragment.findNavController(this).navigate(R.id.action_login_to_registra);
        });

        // --- Listeners para inicio de sesión con redes sociales ---
        // ESTAS FUNCIONES ESTÁN DESACTIVADAS TEMPORALMENTE
        View.OnClickListener socialLoginComingSoon = v ->
                Toast.makeText(getContext(), "Función disponible próximamente", Toast.LENGTH_SHORT).show();

        btnGoogle.setOnClickListener(socialLoginComingSoon);
        btnFacebook.setOnClickListener(socialLoginComingSoon);
        btnGitHub.setOnClickListener(socialLoginComingSoon);

        // --- Listener para "Olvidé mi contraseña" ---
        textViewForgotPassword.setOnClickListener(v ->
                Toast.makeText(getContext(), "¿Necesitas ayuda para recuperar tu cuenta?", Toast.LENGTH_SHORT).show()
        );
    }

    /**
     * Valida y procesa el inicio de sesión con usuario y contraseña.
     */
    private void handleTraditionalLogin() {
        String user = editTextUser.getText().toString().trim();
        String pass = editTextPassword.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(getContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // --- SIMULACIÓN DE LOGIN EXITOSO ---
        // Aquí va tu lógica real para validar las credenciales con tu base de datos.
        // Por ahora, siempre será exitoso si los campos no están vacíos.
        Toast.makeText(getContext(), "¡Bienvenido de vuelta!", Toast.LENGTH_SHORT).show();
        navigateToHome();
    }

    /**
     * Navega a la pantalla principal de la aplicación.
     */
    private void navigateToHome() {
        // Comprueba si el fragmento está añadido a la actividad antes de navegar para evitar crashes.
        if (isAdded()) {
            NavHostFragment.findNavController(this).navigate(R.id.action_login_to_inicio01);
        }
    }
}