package josepardo.edu.pe.gymwp.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button; // Asegúrate de importar Button
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation; // Importante: Importa Navigation
import josepardo.edu.pe.gymwp.R; // Importa tu R

public class inicio extends Fragment {

    Button btnIniciar; // Declara el botón

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla el layout
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Encuentra el botón que está en fragment_inicio.xml
        btnIniciar = view.findViewById(R.id.btnIniciar);

        // 2. Asigna el "ClickListener"
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Llama a la acción para navegar
                //    'v' es la vista (el botón) que se acaba de presionar
                Navigation.findNavController(v).navigate(R.id.action_inicio_to_login);
            }
        });

        // Forma más corta (con lambda):
        // btnIniciar.setOnClickListener( v -> {
        //     Navigation.findNavController(v).navigate(R.id.action_inicio_to_login);
        // });
    }
}