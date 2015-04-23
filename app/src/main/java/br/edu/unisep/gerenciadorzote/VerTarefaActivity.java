package br.edu.unisep.gerenciadorzote;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ESutil on 21/04/2015.
 */
public class VerTarefaActivity extends Activity{

    private TextView lblTitulo;
    private TextView lblDescricao;
    private TextView lblPrazo;
    private Button btnConcluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_selecionado);

        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        lblPrazo = (TextView) findViewById(R.id.lblPrazo);
        lblDescricao = (TextView) findViewById(R.id.lblDescricao);
        btnConcluir = (Button) findViewById(R.id.btnConcluir);
    }

}
