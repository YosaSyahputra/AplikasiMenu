package com.example.aplikasimenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    private int jumlahBarang = 1; // Jumlah default adalah 1
    private TextView kuantitasTextView;
    private TextView totalHargaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Inisialisasi elemen tampilan
        ImageView gambarItem = findViewById(R.id.gambar_item);
        TextView namaItem = findViewById(R.id.nama_item);
        TextView keteranganItem = findViewById(R.id.keterangan_item);
        TextView hargaItem = findViewById(R.id.harga_item);
        totalHargaTextView = findViewById(R.id.total_harga);

        // Dapatkan data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            int gambar = intent.getIntExtra("gambar", 0);
            String nama = intent.getStringExtra("nama");
            String keterangan = intent.getStringExtra("keterangan");
            String harga = intent.getStringExtra("harga");

            // Tampilkan data pada elemen tampilan
            gambarItem.setImageResource(gambar);
            namaItem.setText(nama);
            keteranganItem.setText(keterangan);
            hargaItem.setText(harga);
        }

        // Temukan elemen tampilan lainnya dan tombol
        kuantitasTextView = findViewById(R.id.kuantitas_menu);
        Button btnTambah = findViewById(R.id.btn_tambah);
        Button btnKurang = findViewById(R.id.btn_kurang);
        Button btnPesan = findViewById(R.id.btn_pesan);

        // Update kuantitasTextView dengan jumlah default
        updateKuantitasTextView();

        // Tambahkan aksi onClickListener untuk tombol tambah
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahBarang++;
                updateKuantitasTextView();
            }
        });

        // Tambahkan aksi onClickListener untuk tombol kurang
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jumlahBarang > 1) {
                    jumlahBarang--;
                    updateKuantitasTextView();
                }
            }
        });

        // Tambahkan aksi onClickListener untuk tombol pesan
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Siapkan data yang akan dikirim ke ReceiptActivity
                Intent intent = new Intent(CartActivity.this, ReceiptActivity.class);
                intent.putExtra("jumlahBarang", jumlahBarang);
                intent.putExtra("nama", namaItem.getText().toString());
                intent.putExtra("totalharga", totalHargaTextView.getText().toString());
                intent.putExtra("gambarId", getIntent().getIntExtra("gambar", 0)); // Kirim ID gambar
                startActivity(intent);
            }
        });

    }

    // Fungsi untuk memperbarui TextView kuantitas dan total harga
    private void updateKuantitasTextView() {
        kuantitasTextView.setText("" + jumlahBarang);
        int hargaSatuan = Integer.parseInt(getIntent().getStringExtra("harga").replaceAll("[^0-9]", ""));
        int totalHarga = jumlahBarang * hargaSatuan;
        totalHargaTextView.setText("Rp." + totalHarga);
    }
}
