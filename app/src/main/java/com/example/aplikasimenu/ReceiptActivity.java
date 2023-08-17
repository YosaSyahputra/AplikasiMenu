package com.example.aplikasimenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        ImageView gambarItem = findViewById(R.id.receipt_image);
        TextView namaItemTextView = findViewById(R.id.receipt_name);
        TextView jumlahItemTextView = findViewById(R.id.receipt_quantity);
        TextView totalHargaTextView = findViewById(R.id.receipt_total);

        int gambarId = getIntent().getIntExtra("gambarId", 0); // Ambil ID gambar
        int jumlahBarang = getIntent().getIntExtra("jumlahBarang", 0);
        String namaItem = getIntent().getStringExtra("nama");
        String totalHarga = getIntent().getStringExtra("totalharga");

        // Tampilkan data pada TextView di ReceiptActivity
        gambarItem.setImageResource(gambarId); // Set gambar dengan ID gambar
        namaItemTextView.setText(namaItem);
        jumlahItemTextView.setText("Jumlah Item: " + jumlahBarang);
        totalHargaTextView.setText("Total Harga: " + totalHarga);

        // Temukan tombol "Kembali ke Menu"
        Button btnKembaliKeMenu = findViewById(R.id.btn_kembali_ke_menu);

        btnKembaliKeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReceiptActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Tutup ReceiptActivity agar tidak dapat kembali dengan tombol "back"
            }
        });
    }
}

