package com.afdhalzikri.tambahanpenghasilanpegawai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Afdhal Zikri on 15/10/2018.
 */

public class output extends AppCompatActivity {
    TextView tpp_bulan_ini,sasaran_kerja_pegawai, perilaku_kerja, disiplin, komitmen, penilaian_prestasi_kerja, kinerja, kehadiran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);
        tpp_bulan_ini = findViewById(R.id.tv_tpp_bulan_ini);
        sasaran_kerja_pegawai = findViewById(R.id.tv_sasaran_kerja_pegawai);
        perilaku_kerja = findViewById(R.id.tv_perilaku_kerja);
        disiplin = findViewById(R.id.disiplin);
        komitmen = findViewById(R.id.komitmen);
        penilaian_prestasi_kerja = findViewById(R.id.tv_penilaian_prestasi_kerja);
        kinerja = findViewById(R.id.tv_kinerja);
        kehadiran = findViewById(R.id.tv_kehadiran);

        tpp_bulan_ini.setText(MainActivity.TPPBulanIni.toString());
        sasaran_kerja_pegawai.setText(MainActivity.SasaranKerjaPegawai.toString());
        perilaku_kerja.setText(MainActivity.PerilakuKerja.toString());
        disiplin.setText(MainActivity.Disiplin.toString());
        komitmen.setText(MainActivity.Komitmen.toString());
        penilaian_prestasi_kerja.setText(MainActivity.PenilaianPrestasiKerja.toString());
        kinerja.setText(MainActivity.Kinerja.toString());
        kehadiran.setText(MainActivity.Kehadiran.toString());
    }
}
