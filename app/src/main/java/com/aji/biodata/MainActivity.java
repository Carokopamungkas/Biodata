package com.aji.biodata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnPanggil, btnEmail, btnAlamat;

    String googleMap = "com.google.android.apps.maps";
    Uri gmmInterntUri;
    Intent mapIntent;
    String Rumah = "-7.929989,111.969320";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmail = findViewById(R.id.btnEmail);
        btnPanggil = findViewById(R.id.btnPanggil);
        btnAlamat = (Button) findViewById(R.id.btnAlamat);

        btnPanggil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nomor = "082257068408";
                Intent memanggil = new Intent(Intent.ACTION_DIAL);
                memanggil.setData(Uri.fromParts("tel", nomor,null));
                startActivity(memanggil);
            }

        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent email = new Intent(Intent.ACTION_SEND);
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","111202080013@mhs.dinus.ac.id", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            }
        });

        btnAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("\"google.streetview:cbll=-7.929991,111.969364");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmInterntUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) !=null ){
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Google map belum terinstal",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}