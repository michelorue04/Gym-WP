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

public class inicio03 extends Fragment {

    private MaterialCardView cardBalanceado, cardPecho, cardEspalda, cardBrazos, cardPiernas, cardAbdomen, cardGluteos;
    private Button btnContinuar;
    private String opcionSeleccionada = null;

    public inicio03() {
        // Constructor vacío requerido
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio03, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencias de las tarjetas
        cardBalanceado = view.findViewById(R.id.cardBalanceado);
        cardPecho = view.findViewById(R.id.cardPecho);
        cardEspalda = view.findViewById(R.id.cardEspalda);
        cardBrazos = view.findViewById(R.id.cardBrazos);
        cardPiernas = view.findViewById(R.id.cardPiernas);
        cardAbdomen = view.findViewById(R.id.cardAbdomen);
        cardGluteos = view.findViewById(R.id.cardGluteos);

        btnContinuar = view.findViewById(R.id.btnContinuar);

        // Configurar los listeners de cada tarjeta
        cardBalanceado.setOnClickListener(v -> seleccionarOpcion("Balanceado"));
        cardPecho.setOnClickListener(v -> seleccionarOpcion("Pecho"));
        cardEspalda.setOnClickListener(v -> seleccionarOpcion("Espalda"));
        cardBrazos.setOnClickListener(v -> seleccionarOpcion("Brazos"));
        cardPiernas.setOnClickListener(v -> seleccionarOpcion("Piernas"));
        cardAbdomen.setOnClickListener(v -> seleccionarOpcion("Abdomen"));
        cardGluteos.setOnClickListener(v -> seleccionarOpcion("Glúteos"));

        // Botón continuar
        btnContinuar.setOnClickListener(v -> {
            if (opcionSeleccionada == null) {
                Toast.makeText(getContext(), "Selecciona un grupo muscular para continuar.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Has elegido: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(this).navigate(R.id.action_inicio03_to_inicio04);
            }
        });

        // Botón volver (ivBack)
        View ivBack = view.findViewById(R.id.ivBack);
        if (ivBack != null) {
            ivBack.setOnClickListener(v -> NavHostFragment.findNavController(this).popBackStack());
        }
    }

    /**
     * Marca una opción como seleccionada y actualiza los colores de las tarjetas.
     */
    private void seleccionarOpcion(String opcion) {
        opcionSeleccionada = opcion;

        // Restaurar colores por defecto
        resetearColores();

        int colorNaranja = getResources().getColor(R.color.colorNaranja);
        int colorFondo = getResources().getColor(R.color.colorNaranjaFondo);

        switch (opcion) {
            case "Balanceado":
                cardBalanceado.setStrokeColor(colorNaranja);
                cardBalanceado.setCardBackgroundColor(colorFondo);
                break;
            case "Pecho":
                cardPecho.setStrokeColor(colorNaranja);
                cardPecho.setCardBackgroundColor(colorFondo);
                break;
            case "Espalda":
                cardEspalda.setStrokeColor(colorNaranja);
                cardEspalda.setCardBackgroundColor(colorFondo);
                break;
            case "Brazos":
                cardBrazos.setStrokeColor(colorNaranja);
                cardBrazos.setCardBackgroundColor(colorFondo);
                break;
            case "Piernas":
                cardPiernas.setStrokeColor(colorNaranja);
                cardPiernas.setCardBackgroundColor(colorFondo);
                break;
            case "Abdomen":
                cardAbdomen.setStrokeColor(colorNaranja);
                cardAbdomen.setCardBackgroundColor(colorFondo);
                break;
            case "Glúteos":
                cardGluteos.setStrokeColor(colorNaranja);
                cardGluteos.setCardBackgroundColor(colorFondo);
                break;
        }
    }

    /**
     * Restaura todas las tarjetas a su color gris por defecto.
     */
    private void resetearColores() {
        int grisFondo = getResources().getColor(R.color.colorGrisFondo);
        int transparente = getResources().getColor(android.R.color.transparent);

        cardBalanceado.setCardBackgroundColor(grisFondo);
        cardBalanceado.setStrokeColor(transparente);

        cardPecho.setCardBackgroundColor(grisFondo);
        cardPecho.setStrokeColor(transparente);

        cardEspalda.setCardBackgroundColor(grisFondo);
        cardEspalda.setStrokeColor(transparente);

        cardBrazos.setCardBackgroundColor(grisFondo);
        cardBrazos.setStrokeColor(transparente);

        cardPiernas.setCardBackgroundColor(grisFondo);
        cardPiernas.setStrokeColor(transparente);

        cardAbdomen.setCardBackgroundColor(grisFondo);
        cardAbdomen.setStrokeColor(transparente);

        cardGluteos.setCardBackgroundColor(grisFondo);
        cardGluteos.setStrokeColor(transparente);
    }
}
