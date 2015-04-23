package br.edu.unisep.gerenciadorzote.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.unisep.gerenciadorzote.R;

/**
 * Created by ESutil on 21/04/2015.
 */
public class TarefaCursorAdapter extends CursorAdapter {

    private LayoutInflater inflater;

    public TarefaCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    // Cria a view do item da lista
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View item = inflater.inflate(R.layout.item_tela, null);
        return item;
    }

    // Associa os valores do cursor para os campos do layout do item.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView lblTitulo = (TextView) view.findViewById(R.id.lblTitulo);

        int idxTitulo = cursor.getColumnIndex("titulo");
        lblTitulo.setText(cursor.getString(idxTitulo));

        TextView lblDescricao = (TextView) view.findViewById(R.id.lblDescricao);

        int idxDescricao = cursor.getColumnIndex("descricao");
        lblDescricao.setText(cursor.getString(idxDescricao));

        TextView lblPrazo = (TextView) view.findViewById(R.id.lblPrazo);

        int idxPrazo = cursor.getColumnIndex("prazo");
        long time = cursor.getLong(idxPrazo);

        Date prazo = new Date(time);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        lblPrazo.setText(df.format(prazo));
    }
}
