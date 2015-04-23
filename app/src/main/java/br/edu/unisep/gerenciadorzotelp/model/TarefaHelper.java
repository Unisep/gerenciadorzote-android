package br.edu.unisep.gerenciadorzotelp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ESutil on 21/04/2015.
 */
public class TarefaHelper  extends SQLiteOpenHelper {
    public TarefaHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Método de criação das tabelas no banco.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tarefas (" +
                " _id integer primary key, " +
                " titulo text, " +
                " descricao text, " +
                " prazo integer)";

        // Executa o comando sql no banco.
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
