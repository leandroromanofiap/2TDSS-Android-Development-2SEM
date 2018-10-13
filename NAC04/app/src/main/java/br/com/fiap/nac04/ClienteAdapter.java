package br.com.fiap.nac04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ClienteAdapter extends BaseAdapter {

    Context context;
    List<Cliente> clientes;

    public ClienteAdapter(Context context, List<Cliente> clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public int getCount() {
        return this.clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return this.clientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        Cliente cliente = this.clientes.get(position);

        View v = layoutInflater.inflate(R.layout.listview_cliente, null);

        TextView txtNome = v.findViewById(R.id.txtNome);
        TextView txtTelefone = v.findViewById(R.id.txtTelefone);
        TextView txtEmail = v.findViewById(R.id.txtEmail);

        txtNome.setText(cliente.getNome());
        txtTelefone.setText(cliente.getTelefone());
        txtEmail.setText(cliente.getEmail());

        return v;
    }
}
