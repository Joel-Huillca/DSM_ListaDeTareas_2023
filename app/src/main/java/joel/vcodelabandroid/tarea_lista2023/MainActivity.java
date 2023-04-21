package joel.vcodelabandroid.tarea_lista2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


//Implementamos un onClick con la interfac y el OnItem
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    //Declaramos
    private Button mBtnAñadir;
    private ListView mListView;
    private EditText mEditText;

    private List<String> mLista = new ArrayList<>(); //Lista
    private ArrayAdapter<String> mAdapter; //Llenamos los Datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAñadir = findViewById(R.id.btnAgregar);
        mBtnAñadir.setOnClickListener(this);

        mListView = findViewById(R.id.listView);
        mListView.setOnItemClickListener(this);

        mEditText = findViewById(R.id.etLista);

    }

    @Override
    public void onClick(View view) {
     switch (view.getId()){
         /**Cuando le haga click, tomara el texto (tambien el toString y el trim para los espacios en blanco)**/
         case R.id.btnAgregar: String texto = mEditText.getText().toString().trim();
              mLista.add(texto);//Lo añado a la lista
             mEditText.getText().clear();//para cuando aorete el boton se me borre los datos
             //Creamos un adaptador para poner los datos que están en la lista
             //              Adapter   =  (Conexto=this , Vista=vista pre-hecha, Los datos que llevaran dentro del adaptrador)
             mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mLista);
              mListView.setAdapter(mAdapter);//Le pasamos el adaptaer

     }
    }

    //Esto es un extra, nos muestra la posición de la tarea agregada
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        Toast.makeText(this,"Item N°"+posicion,Toast.LENGTH_SHORT).show();
    }
}