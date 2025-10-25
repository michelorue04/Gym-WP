package josepardo.edu.pe.gymwp.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import josepardo.edu.pe.gymwp.R;

public class registra extends Fragment {

    // 1. Declarar las variables para los elementos de la UI
    private EditText editTextNombre, editTextEmail, editTextPassword;
    private Button btnRegistrar;

    public registra() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registra, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextPassword = view.findViewById(R.id.editTextPassword);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);

        // 3. Añadir la lógica al botón
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto de los campos
                String nombre = editTextNombre.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí iría la lógica para guardar el usuario en la base de datos
                    Toast.makeText(getContext(), "Usuario registrado: " + nombre, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}