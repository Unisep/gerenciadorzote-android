package br.edu.unisep.gerenciadorzotelp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.edu.unisep.gerenciadorzotelp.vo.TarefaVO;

/**
 * Created by ESutil on 21/04/2015.
 */
public class TarefaDAO {

    private TarefaHelper helper;

    public TarefaDAO(Context context){
        this.helper = new TarefaHelper(context, "TAREFAS", null, 1);
    }

    public void salvar(TarefaVO tarefa){

        // possibilita a aplicação gravar no banco
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("titulo", tarefa.getTitulo());
        valores.put("descricao", tarefa.getDescricao());
        valores.put("prazo", tarefa.getPrazo().getTime());

        db.insert("tarefas", null, valores);
        db.close();
    }

    public Cursor listar(){

        // Comunicação somente leitura com o banco.
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] colunas = {"_id",
                "titulo",
                "descricao",
                "prazo"};

        Cursor crs = db.query("tarefas", colunas, null, null, null, null, null);
        return crs;
    }

    public void excluir(long id){

        SQLiteDatabase db = helper.getWritableDatabase();

        String[] valoresWhere = {String.valueOf(id)};

        db.delete("tarefas", "_id = ?", valoresWhere);
        db.close();
    }


}
