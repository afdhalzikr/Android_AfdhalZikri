package com.afdhalzikri.tambahanpenghasilanpegawai;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    EditText tahun, bulan, jumlah_hari_kerja, hadir, izin, sakit, cuti, tanpa_alasan, terlambat, cepat_pulang, uwas, upacara, wirid, apel, senam, skp, orientasi_pelayanan, integritas, komitmen, disiplin, kerjasama, kepemimpinan, lkh, sop;
    Spinner pegawai;
    public static Double SasaranKerjaPegawai, PerilakuKerja, Disiplin, Komitmen, PenilaianPrestasiKerja, Kinerja, Kehadiran, TPPBulanIni;
    Button hitung;
    private ArrayList datapegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tahun = findViewById(R.id.tahun);
        bulan = findViewById(R.id.bulan);
        jumlah_hari_kerja = findViewById(R.id.jumlah_hari_kerja);
        hadir = findViewById(R.id.hadir);
        izin = findViewById(R.id.izin);
        sakit = findViewById(R.id.sakit);
        cuti = findViewById(R.id.cuti);
        tanpa_alasan = findViewById(R.id.tanpa_alasan);
        terlambat =  findViewById(R.id.terlambat);
        cepat_pulang = findViewById(R.id.cepat_pulang);
        uwas = findViewById(R.id.uwas);
        upacara = findViewById(R.id.upacara);
        wirid =  findViewById(R.id.wirid);
        apel = findViewById(R.id.apel);
        senam = findViewById(R.id.senam);
        skp = findViewById(R.id.skp);
        orientasi_pelayanan = findViewById(R.id.orientasi_pelayanan);
        integritas = findViewById(R.id.integritas);
        komitmen = findViewById(R.id.komitmen);
        disiplin = findViewById(R.id.disiplin);
        kerjasama = findViewById(R.id.kerjasama);
        kepemimpinan = findViewById(R.id.kepemimpinan);
        lkh = findViewById(R.id.lkh);
        sop = findViewById(R.id.sop);
        datapegawai = new ArrayList();

        pegawai = findViewById(R.id.nama_pegawai);
        hitung = findViewById(R.id.btn_hitung);
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String PEGAWAI = pegawai.getSelectedItem().toString();
                final String TAHUN = tahun.getText().toString();
                final String BULAN = bulan.getText().toString();
                final String JUMLAH_HARI_KERJA = jumlah_hari_kerja.getText().toString();
                final String HADIR = hadir.getText().toString();
                final String IZIN = izin.getText().toString();
                final String SAKIT = sakit.getText().toString();
                final String CUTI = cuti.getText().toString();
                final String TANPA_ALASAN = tanpa_alasan.getText().toString();
                final String TERLAMBAT = terlambat.getText().toString();
                final String CEPAT_PULANG = cepat_pulang.getText().toString();
                final String UWAS = uwas.getText().toString();
                final String UPACARA = upacara.getText().toString();
                final String WIRID = wirid.getText().toString();
                final String APEL = apel.getText().toString();
                final String SENAM = senam.getText().toString();
                final String SKP = skp.getText().toString();
                final String ORIENTASI_PELAYANAN = orientasi_pelayanan.getText().toString();
                final String INTEGRITAS = integritas.getText().toString();
                final String KOMITMEN = komitmen.getText().toString();
                final String DISIPLIN = disiplin.getText().toString();
                final String KERJASAMA = kerjasama.getText().toString();
                final String KEPEMIMPINAN = kepemimpinan.getText().toString();
                final String LKH = lkh.getText().toString();
                final String SOP = sop.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server.TPP_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.e(TAG, "Login Response: " + response.toString());
                                try {
                                    JSONObject jObj = new JSONObject(response);
                                    int regist_message = jObj.getInt(server.REGISTER_SUCCESS);
                                    SasaranKerjaPegawai = jObj.getDouble(server.SASARANKERJAPEGAWAI);
                                    PerilakuKerja = jObj.getDouble(server.PERILAKUKERJA);
                                    Disiplin = jObj.getDouble(server.DISIPLIN);
                                    Komitmen = jObj.getDouble(server.KOMITMEN);
                                    PenilaianPrestasiKerja = jObj.getDouble(server.PENILAIANPRESTASIKERJA);
                                    Kinerja = jObj.getDouble(server.KINERJA);
                                    Kehadiran = jObj.getDouble(server.KEHADIRAN);
                                    TPPBulanIni = jObj.getDouble(server.TPPBULANINI);
                                    if(regist_message == 1){
                                        Toast.makeText(getApplicationContext(), "Data telah disimpan", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this, output.class));
                                    }
                                    else{
                                        //Displaying an error message on toast
                                        Toast.makeText(getApplicationContext(), "Gagal Menyimpan Data", Toast.LENGTH_LONG).show();
                                    }
                                }
                                catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {;
                                Toast.makeText(getApplicationContext(), "The server unreachable", Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        //Adding parameters to request
                        params.put("pegawai", PEGAWAI);
                        params.put("tahun", TAHUN);
                        params.put("bulan", BULAN);
                        params.put("jumlah_hari_kerja", JUMLAH_HARI_KERJA);
                        params.put("hadir", HADIR);
                        params.put("izin", IZIN);
                        params.put("sakit", SAKIT);
                        params.put("cuti", CUTI);
                        params.put("tanpa_alasan", TANPA_ALASAN);
                        params.put("terlambat", TERLAMBAT);
                        params.put("cepat_pulang", CEPAT_PULANG);
                        params.put("uwas", UWAS);
                        params.put("upacara", UPACARA);
                        params.put("wirid", WIRID);
                        params.put("apel", APEL);
                        params.put("senam", SENAM);
                        params.put("skp", SKP);
                        params.put("orientasi_pelayanan", ORIENTASI_PELAYANAN);
                        params.put("integritas", INTEGRITAS);
                        params.put("komitmen", KOMITMEN);
                        params.put("disiplin", DISIPLIN);
                        params.put("kerjasama", KERJASAMA);
                        params.put("kepemimpinan", KEPEMIMPINAN);
                        params.put("lkh", LKH);
                        params.put("sop", SOP);
                        //returning parameter
                        return params;
                    }
                };
                //Adding the string request to the queue
                Volley.newRequestQueue(MainActivity.this).add(stringRequest);
            }
        });
        getDataPegawai();
    }
    private void getDataPegawai() {
        final StringRequest request = new StringRequest(Request.Method.GET, server.GET_PEGAWAI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            final JSONArray pegawais = new JSONArray(response);
                            for(int i=0; i<pegawais.length(); i++){
                                JSONObject object = pegawais.getJSONObject(i);
                                //get data berdasarkan attribte yang ada dijsonnya (harus sama)
                                String list_pegawai = object.getString("nama_pegawai");
                                datapegawai.add(list_pegawai);
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, datapegawai);
                                pegawai.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Failed Get Data Pegawai", Toast.LENGTH_LONG).show();
                    }
                });
        //Adding the string request to the queue
        Volley.newRequestQueue(this).add(request);
    }
}
