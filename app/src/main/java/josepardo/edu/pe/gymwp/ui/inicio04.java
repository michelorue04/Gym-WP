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

public class inicio04 extends Fragment {

    private MaterialCardView cardPrincipiante, cardIntermediario, cardAvanzado;
    private Button btnContinuar;
    private MaterialCardView selectedCard = null; // Guarda la carta seleccionada

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio04, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1️⃣ Vincular vistas
        cardPrincipiante = view.findViewById(R.id.cardPrincipiante);
        cardIntermediario = view.findViewById(R.id.cardIntermediario);
        cardAvanzado = view.findViewById(R.id.cardAvanzado);
        btnContinuar = view.findViewById(R.id.btnContinuar);

        // 2️⃣ Configurar selección de tarjetas
        setupCardSelection(cardPrincipiante);
        setupCardSelection(cardIntermediario);
        setupCardSelection(cardAvanzado);

        // 3️⃣ Botón continuar
        btnContinuar.setOnClickListener(v -> {
            if (selectedCard == null) {
                // No seleccionó nada
                android.widget.Toast.makeText(getContext(), "Por favor selecciona una opción", android.widget.Toast.LENGTH_SHORT).show();
            } else {
                // Navega al siguiente fragmento
                NavHostFragment.findNavController(this).navigate(R.id.action_inicio04_to_inicio05);
            }
        });
    }

    /**
     * Configura el comportamiento de selección de cada tarjeta
     */
    private void setupCardSelection(MaterialCardView card) {
        card.setOnClickListener(v -> {
            // Desmarcar la anterior
            if (selectedCard != null && selectedCard != card) {
                resetCardStyle(selectedCard);
            }

            // Marcar la nueva
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
     * Restaura el estilo normal
     */
    private void resetCardStyle(MaterialCardView card) {
        card.setCardBackgroundColor(getResources().getColor(R.color.colorGrisFondo));
        card.setStrokeWidth(0);
    }
}
