package br.edu.utfpr.avaliacao2samuel;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MeuAdapter extends BaseAdapter {

    private Context c;
    private Cursor reg;

    public MeuAdapter(Context c, Cursor reg) {
        this.c = c;
        this.reg = reg;
    }

    @Override
    public int getCount() {
        return reg.getCount();
    }

    @Override
    public Object getItem(int position) {
        return reg.moveToPosition(position);
    }

    @Override
    public long getItemId(int position) {
        reg.moveToPosition(position);
        return reg.getInt(reg.getColumnIndex("_id"));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.elementos,null);

        TextView tvCodCombustivel = v.findViewById(R.id.tvCodCombustivel);
        TextView tvCidade = v.findViewById(R.id.tvCidade);
        TextView tvQtdeLitro = v.findViewById(R.id.tvQtdeLitros);

        reg.moveToPosition(position);

        int cod = reg.getInt(reg.getColumnIndex("codCombustivel"));
        String cidade = reg.getString(reg.getColumnIndex("cidadeAbastecimento"));
        Double qtdeLitro = reg.getDouble(reg.getColumnIndex("qtdeLitro"));

        tvCodCombustivel.setText(String.valueOf(cod));
        tvCidade.setText(cidade);
        tvQtdeLitro.setText(String.valueOf(qtdeLitro));

        return v;
    }
}
