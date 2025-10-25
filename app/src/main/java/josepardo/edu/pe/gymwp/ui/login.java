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

public class login extends Fragment {

    // --- Vistas de la UI ---
    private EditText editTextUser, editTextPassword;
    private Button btnLogin, btnCrearCuenta;
    private ImageButton btnGoogle, btnFacebook, btnGitHub;
    private CheckBox checkBoxRememberMe;
    private TextView textViewForgotPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Cargar el layout del fragmento
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Enlazar las vistas
        initializeViews(view);

        // Configurar los botones
        setupClickListeners();
    }

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

    private void setupClickListeners() {

        // --- Botón INICIAR SESIÓN ---
        btnLogin.setOnClickListener(v -> handleTraditionalLogin());

        // --- Botón CREAR CUENTA ---
        btnCrearCuenta.setOnClickListener(v ->
                NavHostFragment.findNavController(this).navigate(R.id.action_login_to_registra)
        );

        // --- Botones de redes sociales ---
        View.OnClickListener comingSoon = v ->
                Toast.makeText(getContext(), "Función disponible próximamente", Toast.LENGTH_SHORT).show();

        btnGoogle.setOnClickListener(comingSoon);
        btnFacebook.setOnClickListener(comingSoon);
        btnGitHub.setOnClickListener(comingSoon);

        // --- Texto “¿Olvidaste tu contraseña?” ---
        textViewForgotPassword.setOnClickListener(v ->
                Toast.makeText(getContext(), "Recuperación de contraseña próximamente", Toast.LENGTH_SHORT).show()
        );
    }

    private void handleTraditionalLogin() {
        String user = editTextUser.getText().toString().trim();
        String pass = editTextPassword.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(getContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // --- Si ambos campos están completos, iniciar sesión ---
        Toast.makeText(getContext(), "¡Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();

        // Ir al siguiente fragmento
        navigateToHome();
    }

    private void navigateToHome() {
        if (isAdded()) {
            NavHostFragment.findNavController(this).navigate(R.id.action_login_to_inicio01);
        }
    }
}
