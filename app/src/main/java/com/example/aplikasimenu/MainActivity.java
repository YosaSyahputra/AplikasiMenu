package com.example.aplikasimenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array yang berisi sumber daya gambar menu
        int img_menu [] = {
                R.drawable.nasi_goreng,
                R.drawable.nasi_pecel ,
                R.drawable.opor_ayam,
                R.drawable.sayur_asem,
                R.drawable.gado_gado,
                R.drawable.mie_goreng,
                R.drawable.soto_ayam
        };

        // Array yang berisi nama-nama menu
        String nama_menu [] =  {
                "Nasi Goreng",
                "Nasi Pecel",
                "Opor ayam",
                "Sayur Asem",
                "Gado-gado",
                "Mie Goreng",
                "Soto Ayam"
        };

        // Array yang berisi keterangan atau deskripsi menu
        String ket_menu [] = {
                "Nasi goreng dengan bumbu istimewa",
                "Nasi dengan sayur pecel khas Jawa",
                "Ayam empuk dengan kuah opor yang lezat",
                "Sayuran segar dengan kuah asem-asem",
                "Gado-gado dengan beragam bahan segar",
                "Mie goreng dengan bumbu yang gurih",
                "Soto ayam hangat dengan rempah pilihan"
        };

        // Array yang berisi harga-harga menu
        String harga_menu [] = {
                "Rp. 12.000",
                "RP. 10.000",
                "Rp. 15.000",
                "Rp. 10.000",
                "Rp. 10.000",
                "Rp. 12.000",
                "Rp. 15.000"
        };

        // Menghubungkan list view dari layout dengan objek listView
        listView =  findViewById(R.id.list_menu);

        // Membuat objek AdapterMenu dengan data yang diberikan
        AdapterMenu adapter_menu = new AdapterMenu(MainActivity.this,  nama_menu, img_menu, ket_menu, harga_menu);

        // Mengatur adapter untuk listView
        listView.setAdapter(adapter_menu);
    }
}
