package com.example.aplikasimenu;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterMenu extends ArrayAdapter<String> {
    String list_nama[];
    int list_gambar[];
    String list_keterangan[];
    String list_harga[];
    Activity activity;

    public AdapterMenu(MainActivity activity, String[] list_nama, int[] list_gambar, String[] list_keterangan, String[] list_harga) {
        super(activity, R.layout.list_item, list_nama);
        this.list_nama = list_nama;
        this.list_gambar = list_gambar;
        this.list_keterangan = list_keterangan;
        this.list_harga = list_harga;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View tampil = inflater.inflate(R.layout.list_item, null);

        ImageView img;
        TextView nama, ket, harga;
        img = tampil.findViewById(R.id.gambar_item);
        nama = tampil.findViewById(R.id.nama_item);
        ket = tampil.findViewById(R.id.keterangan_item);
        harga = tampil.findViewById(R.id.harga_item);
        nama.setText(list_nama[position]);
        img.setImageResource(list_gambar[position]);
        ket.setText(list_keterangan[position]);
        harga.setText(list_harga[position]);
        Button btnPesan;
        btnPesan = tampil.findViewById(R.id.tombol_pesan);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CartActivity.class);
                intent.putExtra("gambar", list_gambar[position]);
                intent.putExtra("nama", list_nama[position]);
                intent.putExtra("keterangan", list_keterangan[position]);
                intent.putExtra("harga", list_harga[position]);
                activity.startActivity(intent);
            }
        });

        return tampil;
    }
}
