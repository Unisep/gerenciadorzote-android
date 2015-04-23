package br.edu.unisep.gerenciadorzote;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import br.edu.unisep.gerenciadorzote.adapter.TarefaCursorAdapter;
import br.edu.unisep.gerenciadorzote.model.TarefaDAO;
import br.edu.unisep.gerenciadorzote.vo.TarefaVO;


public class MainActivity extends ListActivity {

    private TarefaCursorAdapter adapter;
    private Cursor cursor;
    private TarefaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new TarefaDAO(this);

        cursor = dao.listar();

        adapter = new TarefaCursorAdapter(this, cursor, 0);

        setListAdapter(adapter);


        registerForContextMenu(getListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mn_excluir) {
            AdapterView.AdapterContextMenuInfo menuInf = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            long id = menuInf.id;

            dao.excluir(id);

            cursor = dao.listar();
            adapter.changeCursor(cursor);
            adapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater = getMenuInflater();


        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mn_novo) {
            Intent intent = new Intent(this, InclusaoTarefaActivity.class);
            startActivityForResult(intent, 0);
        }
        return true;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        TarefaVO trabalho = (TarefaVO) data.getSerializableExtra("Tarefa");
        if (requestCode == 0 && resultCode == RESULT_OK) {

            cursor = dao.listar();
            adapter.changeCursor(cursor);
            adapter.notifyDataSetChanged();
        }

        adapter.notifyDataSetChanged();
    }

}
