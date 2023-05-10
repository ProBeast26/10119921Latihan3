package com.fakih.f10119921latihan3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// Nama : Fakih Syafalik
// Kelas : IF-10K
// Nim : 10119921
// Tgl Pengerjaan : 10 Mei 2023
public class DoneActivity extends AppCompatActivity {
    @BindView(R.id.txtDoneTitle)
    TextView txtNama;
    @BindString(R.string.activation_beres)
    String beres;
    @BindString(R.string.activation_sudah_bisa)
    String sudahBisa;
    @BindString(R.string.activation_setiap)
    String setiap;
    @BindString(R.string.activation_buat)
    String buat;

    public static final String ID_EXTRA_MSG_EXIT = "com.albeeak.f10119921latihan3.MSG_EXIT";

    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        ButterKnife.bind(this);
        bindExtra();
    }

    private void bindExtra(){
        //Menampung value yang dilempar dari BiodatActivity
        Intent intent = getIntent();
        name = intent.getStringExtra(BiodataActivity.ID_EXTRA_MSG);
        // Mengeset nama sesuai dengan data nama yang dilempar menjadi satu kesatuan kalimat
        txtNama.setText(beres+" "+name+" "+sudahBisa+" "+name+" "+setiap+" "+name+" "+buat);
    }

    @OnClick(R.id.btnDoneNext)
    public void selesai(View view) {
        //Mengeset agar ketika menekan tombol Oke, Aplikasi ngeclose
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(ID_EXTRA_MSG_EXIT, true);
        startActivity(intent);
    }
}