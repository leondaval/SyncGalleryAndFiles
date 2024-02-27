package app.SyncGalleryAndFiles;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SelectionAppActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_application);

        requestPermissionMemoryAll();

        TextView buttonSyncGallery = findViewById(R.id.buttonSyncGallery);
        TextView buttonSyncFiles = findViewById(R.id.buttonSyncFiles);

        if(buttonSyncGallery!=null) { //Verifica quale dei due bottoni ha premuto l'utente
            buttonSyncGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Nascondi il bottone
                    buttonSyncGallery.setVisibility(View.GONE);

                    //Salva un valore corrispondente alla scelta precedente dell'utente sull'applicazione e lo invia alla MainActivity
                    Intent intent = new Intent(SelectionAppActivity.this, MainActivity.class);
                    intent.putExtra("SelectedApplication", "SyncGallery");

                    // Passa alla MainActivity
                    startActivity(intent);
                    finish();

                }
            });
        }

        if(buttonSyncFiles!=null) {

            buttonSyncFiles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Nascondi il bottone
                    buttonSyncFiles.setVisibility(View.GONE);

                    Intent intent = new Intent(SelectionAppActivity.this, MainActivity.class);
                    intent.putExtra("SelectedApplication", "SyncFiles");

                    // Passa alla MainActivity
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    private void requestPermissionMemoryAll() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
        requestPermissionLauncher.launch(intent);
    }

}