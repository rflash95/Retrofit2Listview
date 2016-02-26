package com.teknorial.retrofit2listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Teknorial on 13/02/2016.
 */
public class LihatDetailBuku extends AppCompatActivity {
    //mendefinisikan
    private TextView textViewIdBuku;
    private TextView textViewNamaBuku;
    private TextView textViewHargaBuku;
    private TextView textViewStatusBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_detail);

        //inisialisasi
        textViewIdBuku = (TextView) findViewById(R.id.txtIdBuku);
        textViewNamaBuku = (TextView) findViewById(R.id.txtNamaBuku);
        textViewHargaBuku = (TextView) findViewById(R.id.txtHargaBuku);
        textViewStatusBuku = (TextView) findViewById(R.id.txtStatusBuku);
        //mengambil intent
        Intent intent = getIntent();
        //Menampilkan nilai hasil parsing dari intent
        textViewIdBuku.setText("ID : "+String.valueOf(intent.getIntExtra(MainActivity.ID_BUKU,0)));
        textViewNamaBuku.setText("Nama : "+intent.getStringExtra(MainActivity.NAMA_BUKU));
        textViewHargaBuku.setText("Harga : Rp."+String.valueOf(intent.getIntExtra(MainActivity.HARGA_BUKU,0)));
        textViewStatusBuku.setText("Status : "+intent.getStringExtra(MainActivity.STATUS_BUKU));

    }
}
