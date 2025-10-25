package josepardo.edu.pe.gymwp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.card.MaterialCardView;
import josepardo.edu.pe.gymwp.R;

public class inicio01 extends Fragment {

    private MaterialCardView cardHipertrofia, cardDefinicion, cardPerderPeso;
    private Button btnComenzar, btnYaTengoCuenta;
    private String opcionSeleccionada = null; // Guarda qué opción eligió el usuario

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio01, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- Enlazar vistas ---
        cardHipertrofia = view.findViewById(R.id.cardHipertrofia);
        cardDefinicion = view.findViewById(R.id.cardDefinicion);
        cardPerderPeso = view.findViewById(R.id.cardPerderPeso);
        btnComenzar = view.findViewById(R.id.btnComenzar);
        btnYaTengoCuenta = view.findViewById(R.id.btnYaTengoCuenta);

        // --- Selección de tarjetas ---
        cardHipertrofia.setOnClickListener(v -> seleccionarOpcion("Hipertrofia"));
        cardDefinicion.setOnClickListener(v -> seleccionarOpcion("Definición"));
        cardPerderPeso.setOnClickListener(v -> seleccionarOpcion("Perder peso"));

        // --- Botón Comenzar ---
        btnComenzar.setOnClickListener(v -> {
            if (opcionSeleccionada == null) {
                Toast.makeText(getContext(), "Selecciona una opción antes de continuar.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Opción elegida: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(this).navigate(R.id.action_inicio01_to_inicio02);
            }
        });

        // --- Botón “Ya tengo una cuenta” ---
        btnYaTengoCuenta.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_inicio01_to_login);
        });
    }

    private void seleccionarOpcion(String opcion) {
        opcionSeleccionada = opcion;

        // Restablecer colores por defecto
        resetearColores();

        // Resaltar la tarjeta elegida
        switch (opcion) {
            case "Hipertrofia":
                cardHipertrofia.setCardBackgroundColor(getResources().getColor(R.color.colorNaranja));
                break;
            case "Definición":
                cardDefinicion.setCardBackgroundColor(getResources().getColor(R.color.colorNaranja));
                break;
            case "Perder peso":
                cardPerderPeso.setCardBackgroundColor(getResources().getColor(R.color.colorNaranja));
                break;
        }
    }

    private void resetearColores() {
        int grisClaro = getResources().getColor(android.R.color.darker_gray);
        cardHipertrofia.setCardBackgroundColor(grisClaro);
        cardDefinicion.setCardBackgroundColor(grisClaro);
        cardPerderPeso.setCardBackgroundColor(grisClaro);
    }
}
