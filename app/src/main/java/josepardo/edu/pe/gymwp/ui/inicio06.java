package josepardo.edu.pe.gymwp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import josepardo.edu.pe.gymwp.R;

public class inicio06 extends Fragment {

    private List<String> diasSeleccionados = new ArrayList<>();
    private Button btnContinuar;

    private MaterialCardView cardLunes, cardMartes, cardMiercoles, cardJueves, cardViernes, cardSabado, cardDomingo;

    public inicio06() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio06, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Cards
        cardLunes = view.findViewById(R.id.cardLunes);
        cardMartes = view.findViewById(R.id.cardMartes);
        cardMiercoles = view.findViewById(R.id.cardMiercoles);
        cardJueves = view.findViewById(R.id.cardJueves);
        cardViernes = view.findViewById(R.id.cardViernes);
        cardSabado = view.findViewById(R.id.cardSabado);
        cardDomingo = view.findViewById(R.id.cardDomingo);

        // Botón
        btnContinuar = view.findViewById(R.id.btnContinuar);
        btnContinuar.setEnabled(false);

        // Set listeners a todas las cards
        setCardClickListener(cardLunes, "Lunes");
        setCardClickListener(cardMartes, "Martes");
        setCardClickListener(cardMiercoles, "Miércoles");
        setCardClickListener(cardJueves, "Jueves");
        setCardClickListener(cardViernes, "Viernes");
        setCardClickListener(cardSabado, "Sábado");
        setCardClickListener(cardDomingo, "Domingo");

        // Navegar al inicio07
        btnContinuar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_inicio06_to_inicio07);
        });
    }

    private void setCardClickListener(MaterialCardView card, String dia) {
        card.setOnClickListener(v -> {
            if (diasSeleccionados.contains(dia)) {
                // Deseleccionar
                diasSeleccionados.remove(dia);
                card.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorGrisFondo));
                card.setStrokeWidth(0);
            } else {
                if (diasSeleccionados.size() < 6) {
                    diasSeleccionados.add(dia);
                    card.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorNaranjaFondo));
                    card.setStrokeWidth(1);
                    card.setStrokeColor(ContextCompat.getColor(getContext(), R.color.colorNaranja));
                }
            }

            // Habilitar botón si hay al menos 2 días seleccionados
            btnContinuar.setEnabled(diasSeleccionados.size() >= 2);
        });
    }
}
