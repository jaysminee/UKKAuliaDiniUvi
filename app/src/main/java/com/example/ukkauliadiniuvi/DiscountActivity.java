package com.example.ukkauliadiniuvi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
public class DiscountActivity extends AppCompatActivity {


    EditText etHarga;
    EditText etDiskon;
    TextView hasil;
    int txtDiskon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_discount);

        etHarga = findViewById(R.id.etHarga);
        etDiskon = findViewById(R.id.etDiskon);
        Button btnProses = findViewById(R.id.btnProses);
        hasil = findViewById(R.id.hasil);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses(v);
            }
        });
    }


        public void proses (View view) {
        try {
            // Ambil nilai dari EditText
            String harga = etHarga.getText().toString().trim();
            String diskon = etDiskon.getText().toString().trim();
            // Validasi diskon tidak lebih dari 100%
//            if (txtDiskon > 0) {
//                Toast.makeText(DiscountActivity.this, "Tidak valid",Toast.LENGTH_SHORT).show();
//                return;
//            }
            // Validasi diskon tidak lebih dari 100%
            if (txtDiskon > 100) {
                Toast.makeText(DiscountActivity.this, "Tidak valid",Toast.LENGTH_SHORT).show();
                return;
            }


            // Validasi input
            if (harga.isEmpty() || diskon.isEmpty()) {
                hasil.setText("Harga dan Diskon harus diisi!");
                return;
            }
            int txtHarga = Integer.parseInt(harga);
            int txtDiskon = Integer.parseInt(diskon);

            int potongan = txtHarga * txtDiskon / 100;
            int total = txtHarga - potongan;
//            hasil.setText(String.valueOf(hasil));

            DecimalFormat formatter = new DecimalFormat("#,###");
            String formattedTotal = formatter.format(total);

            hasil.setText("Total Harga: Rp" + formattedTotal);
        } catch (Exception e) {
            hasil.setText("Input tidak valid!");
        }
    }
}