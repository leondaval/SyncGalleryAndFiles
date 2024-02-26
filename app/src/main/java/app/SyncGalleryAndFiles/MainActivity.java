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
        if (selectedApplication.equals("SyncGallery"))
            startActivity(new Intent(MainActivity.this, SyncGallery.class)); // Avvia la classe SyncGallery
        else
            startActivity(new Intent(MainActivity.this, SyncFiles.class)); // Avvia la classe SyncFiles
    }
}