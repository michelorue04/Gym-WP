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

public class inicio02 extends Fragment {

    private MaterialCardView cardHipertrofia, cardDefinicion, cardPerderPeso;
    private Button btnComenzar;
    private String opcionSeleccionada = null; // Guarda la selección del usuario

    public inicio02() {
        // Constructor vacío requerido
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio02, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Enlazar vistas
        cardHipertrofia = view.findViewById(R.id.cardHipertrofia);
        cardDefinicion = view.findViewById(R.id.cardDefinicion);
        cardPerderPeso = view.findViewById(R.id.cardPerderPeso);
        btnComenzar = view.findViewById(R.id.btnComenzar);

        // Listeners de selección de tarjeta
        cardHipertrofia.setOnClickListener(v -> seleccionarOpcion("Hipertrofia"));
        cardDefinicion.setOnClickListener(v -> seleccionarOpcion("Definición"));
        cardPerderPeso.setOnClickListener(v -> seleccionarOpcion("Perder peso"));

        // Listener del botón "Comenzar"
        btnComenzar.setOnClickListener(v -> {
            if (opcionSeleccionada == null) {
                Toast.makeText(getContext(), "Selecciona una opción antes de continuar.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Opción elegida: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(this).navigate(R.id.action_inicio02_to_inicio03);
            }
        });
    }

    private void seleccionarOpcion(String opcion) {
        opcionSeleccionada = opcion;

        // Restaurar colores por defecto
        resetearColores();

        // Resaltar la tarjeta seleccionada
        int colorNaranja = getResources().getColor(R.color.colorNaranja);
        int colorFondo = getResources().getColor(R.color.colorNaranjaFondo);

        switch (opcion) {
            case "Hipertrofia":
                cardHipertrofia.setStrokeColor(colorNaranja);
                cardHipertrofia.setCardBackgroundColor(colorFondo);
                break;
            case "Definición":
                cardDefinicion.setStrokeColor(colorNaranja);
                cardDefinicion.setCardBackgroundColor(colorFondo);
                break;
            case "Perder peso":
                cardPerderPeso.setStrokeColor(colorNaranja);
                cardPerderPeso.setCardBackgroundColor(colorFondo);
                break;
        }
    }

    /**
     * Restaura las tarjetas a su color base.
     */
    private void resetearColores() {
        int grisFondo = getResources().getColor(R.color.colorGrisFondo);
        int transparente = getResources().getColor(android.R.color.transparent);

        cardHipertrofia.setCardBackgroundColor(grisFondo);
        cardHipertrofia.setStrokeColor(transparente);

        cardDefinicion.setCardBackgroundColor(grisFondo);
        cardDefinicion.setStrokeColor(transparente);

        cardPerderPeso.setCardBackgroundColor(grisFondo);
        cardPerderPeso.setStrokeColor(transparente);
    }
}
