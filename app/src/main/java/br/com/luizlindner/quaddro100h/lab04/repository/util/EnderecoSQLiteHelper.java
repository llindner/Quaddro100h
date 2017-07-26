package br.com.luizlindner.quaddro100h.lab04.repository.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.luizlindner.quaddro100h.lab04.domain.model.Endereco;
import br.com.luizlindner.quaddro100h.lab04.domain.model.UF;

/**
 * Created by Luiz on 18/07/2017.
 */

public class EnderecoSQLiteHelper extends SQLiteOpenHelper {

    private Context context;
    private SQLiteDatabase db;

    public EnderecoSQLiteHelper(Context context) {
        super(context, "endereco.db", null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE endereco (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "cep VARCHAR(8) NOT NULL," +
                "logradouro_tipo VARCHAR(50) NOT NULL," +
                "logradouro_nome VARCHAR(255) NOT NULL," +
                "numero VARCHAR(5) NULL," +
                "complemento VARCHAR(80) NULL," +
                "bairro VARCHAR(80) NOT NULL," +
                "municipio VARCHAR(80) NOT NULL," +
                "uf VARCHAR(2) NOT NULL" +
                ");");

    }

    public static EnderecoSQLiteHelper with(Context context){
        return new EnderecoSQLiteHelper(context);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvar(Endereco endereco) throws Exception{
        ContentValues values = new ContentValues();
        values.put("cep", endereco.getCep().getCodigo());
        values.put("logradouro_tipo", endereco.getLogradouroTipo());
        values.put("logradouro_nome", endereco.getLogradouroNome());
        values.put("numero", endereco.getNumero());
        values.put("complemento", endereco.getComplemento());
        values.put("bairro", endereco.getLogradouro().getBairro().getNome());
        values.put("municipio", endereco.getMunicipioNome());
        values.put("uf", endereco.getUf().toString());

        if(endereco.isNullId()){
            db.insert("endereco", null, values);
        }else{
            int rows = db.update("endereco", values, "_id = ?", new String[]{
               endereco.getId().toString()
            });
            Log.i("LAB", "Endereços atualizados: " + rows);
        }
    }

    public void apagar(Endereco endereco) throws Exception{
        if(endereco.isNullId()){
            throw new Exception("ID NULO");
        }
        apagar(endereco.getId());
    }

    public void apagar(Long id) throws Exception{
        Log.i("LAB", "Recebi o id para apagar:" + id);
        int rows = db.delete("endereco", "_id = ?", new String[]{
           id.toString()
        });
        Log.i("LAB", "Endereços apagados: " + rows);
    }

    public Endereco recuperar(Long id) {
        Endereco endereco = Endereco.getInstance();

        Cursor c = db.query("endereco", null, "_id = ?", new String[]{ id.toString() }, null, null, null);
        try {

            if (c.moveToFirst()) {
                endereco = createInstance(c);
            }
        } finally {
            c.close();
        }

        return endereco;
    }

    public Cursor listarTodosPorCursor() throws Exception{
        Cursor c = db.query("endereco", null, null, null, null, null, null);
        return c;
    }

    public ArrayList<Endereco> listarTodos() throws Exception{
        ArrayList<Endereco> lista = new ArrayList<>();


        try{
            Cursor c = listarTodosPorCursor();
            Endereco endereco;
            while (c.moveToNext()){
                endereco = createInstance(c);
                lista.add(endereco);
            }
        }catch (Exception e){
            Log.e("LAB", "Erro ao listar todos", e);
            Toast.makeText(context, "OPS", Toast.LENGTH_LONG).show();
        }

        return lista;
    }

    @NonNull
    private Endereco createInstance(Cursor c) {
        Endereco endereco;
        endereco = Endereco.getInstance(c.getLong(c.getColumnIndex("_id")));
        endereco.setCEPCodigo(c.getString(c.getColumnIndex("cep")));
        endereco.setLogradouroTipo(c.getString(c.getColumnIndex("logradouro_tipo")));
        endereco.setLogradouroNome(c.getString(c.getColumnIndex("logradouro_nome")));
        endereco.setComplemento(c.getString(c.getColumnIndex("complemento")));
        endereco.setNumero(c.getString(c.getColumnIndex("numero")));
        endereco.setBairroNome(c.getString(c.getColumnIndex("bairro")));
        endereco.setMunicipioNome(c.getString(c.getColumnIndex("municipio")));
        endereco.setUf(UF.valueOf(c.getString(c.getColumnIndex("uf"))));
        return endereco;
    }

    public void abrirDB() {
        db = getWritableDatabase();
    }

    public void fecharDB() {
        if(db != null){
            db.close();
        }
    }

}
