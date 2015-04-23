package br.edu.unisep.gerenciadorzote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.edu.unisep.gerenciadorzote.model.TarefaDAO;
import br.edu.unisep.gerenciadorzote.vo.TarefaVO;

/**
 * Created by ESutil on 21/04/2015.
 */
public class InclusaoTarefaActivity extends Activity {

    private EditText txtTitulo;
    private EditText txtDescricao;
    private EditText txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclusao_tarefa);

        Intent intent = getIntent();

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtDescricao = (EditText) findViewById(R.id.txtDescricao);
        txtData = (EditText) findViewById(R.id.txtData);

    }

    public void salvar(View v) {
        TarefaVO tarefa = new TarefaVO();

        tarefa.setTitulo(txtTitulo.getText().toString());
        tarefa.setDescricao(txtDescricao.getText().toString());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = txtData.getText().toString();

        try {
            tarefa.setPrazo(df.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TarefaDAO dao = new TarefaDAO(this);
        dao.salvar(tarefa);

        Intent retorno = new Intent();

        setResult(RESULT_OK, retorno);
        finish();
    }
}
