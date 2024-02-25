package app.SyncGalleryAndFiles;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Verifica l'applicazione di interesse all'utente
        String selectedApplication = getIntent().getStringExtra("SelectedApplication");

        if (selectedApplication.equals("SyncGallery")) {
            // Avvia la classe SyncGallery
            startActivity(new Intent(MainActivity.this, SyncGallery.class));
        }

        else {
            // Avvia la classe SyncFiles
            startActivity(new Intent(MainActivity.this, SyncFiles.class));
        }

    }
}