package br.edu.unisep.gerenciadorzote;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.edu.unisep.gerenciadorzote.model.TarefaDAO;
import br.edu.unisep.gerenciadorzote.vo.TarefaVO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ESutil, Bruno Casali on 21/04/2015.
 */
public class VerTarefaActivity extends Activity{

    private TextView lblTitulo;
    private TextView lblDescricao;
    private TextView lblPrazo;

    private TarefaDAO dao = new TarefaDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_selecionado);

        Intent intent = getIntent();
        long id = intent.getLongExtra("tarefa_id", 0);

        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        lblPrazo = (TextView) findViewById(R.id.lblPrazo);
        lblDescricao = (TextView) findViewById(R.id.lblDescricao);


        Cursor cur = dao.selecionar(id);
        TarefaVO t = new TarefaVO();

        if (cur.moveToFirst())
        {
            t.setTitulo(cur.getString(1));
            t.setDescricao(cur.getString(2));
            t.setPrazo(new Date(cur.getInt(3)));
        }

        lblDescricao.setText(t.getDescricao());
        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
        lblPrazo.setText(simple.format(t.getPrazo()));
        lblTitulo.setText(t.getTitulo());
    }

}