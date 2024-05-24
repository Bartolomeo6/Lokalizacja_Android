package com.example.localization_usage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button guzior;
    EditText dlugoscGeo;
    EditText szerokoscGeo;
    int REQUEST_LOCATION_PERMISSION = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guzior = findViewById(R.id.guzior);
        guzior.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pobierzLokalizacje();
                    }
                }
        );

        dlugoscGeo = findViewById(R.id.dlugoscG);
        szerokoscGeo = findViewById(R.id.szerokoscG);
    }

    private void pobierzLokalizacje(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
        else{
            Log.i("LOKALIZACJA","Wyrazono zgode na lokalizacje");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //pobieranie lok
        }
        else{
            Toast.makeText(this, "Nie wyrazono zgody na udostepnianie lokalizacji. Dzialanie aplikacji zostalo ograniczone.", Toast.LENGTH_SHORT).show();
        }
    }
}