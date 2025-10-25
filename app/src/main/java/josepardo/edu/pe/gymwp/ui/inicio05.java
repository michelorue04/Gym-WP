package josepardo.edu.pe.gymwp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.card.MaterialCardView;

import josepardo.edu.pe.gymwp.R;

public class inicio05 extends Fragment {

    private MaterialCardView cardGimnasioBasico, cardGimnasioAvanzado;
    private Button btnContinuar;
    private MaterialCardView selectedCard = null; // Guarda la tarjeta seleccionada

    public inicio05() {
        // Constructor vacío requerido
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio05, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 🔹 1. Enlazar vistas
        cardGimnasioBasico = view.findViewById(R.id.cardGimnasioBasico);
        cardGimnasioAvanzado = view.findViewById(R.id.cardGimnasioAvanzado);
        btnContinuar = view.findViewById(R.id.btnContinuar);

        // 🔹 2. Configurar selección de tarjetas
        setupCardSelection(cardGimnasioBasico);
        setupCardSelection(cardGimnasioAvanzado);

        // 🔹 3. Acción del botón Continuar
        btnContinuar.setOnClickListener(v -> {
            if (selectedCard == null) {
                android.widget.Toast.makeText(getContext(),
                        "Por favor selecciona una opción",
                        android.widget.Toast.LENGTH_SHORT).show();
            } else {
                // Navegar al siguiente fragmento
                NavHostFragment.findNavController(this).navigate(R.id.action_inicio05_to_inicio06);
            }
        });
    }

    /**
     * Configura el comportamiento al hacer clic en una tarjeta
     */
    private void setupCardSelection(MaterialCardView card) {
        card.setOnClickListener(v -> {
            // Desmarcar la tarjeta anterior (si existía)
            if (selectedCard != null && selectedCard != card) {
                resetCardStyle(selectedCard);
            }

            // Marcar la nueva tarjeta seleccionada
            selectedCard = card;
            applySelectedStyle(card);
        });
    }

    /**
     * Aplica el estilo de selección (resaltado)
     */
    private void applySelectedStyle(MaterialCardView card) {
        card.setCardBackgroundColor(getResources().getColor(R.color.colorNaranjaFondo));
        card.setStrokeColor(getResources().getColor(R.color.colorNaranja));
        card.setStrokeWidth(3);
    }

    /**
     * Restaura el estilo normal (sin selección)
     */
    private void resetCardStyle(MaterialCardView card) {
        card.setCardBackgroundColor(getResources().getColor(R.color.colorGrisFondo));
        card.setStrokeWidth(0);
    }
}
