package app.SyncGalleryAndFiles;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Verifica l'applicazione di interesse all'utente
        String selectedApplication = getIntent().getStringExtra("SelectedApplication");

        if (checkPermissionMemory() && checkPermissionNotifications()) // Verifica se i permessi sono già stati concessi durante un esecuzione dell'app in passato

            Toast.makeText(MainActivity.this, "Permessi necessari, già concessi, complimenti!", Toast.LENGTH_SHORT).show();

        if (selectedApplication.equals("SyncGallery"))
            startActivity(new Intent(MainActivity.this, SyncGallery.class)); // Avvia la classe SyncGallery
        else
            startActivity(new Intent(MainActivity.this, SyncFiles.class)); // Avvia la classe SyncFiles
    }

    private boolean checkPermissionMemory() {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private boolean checkPermissionNotifications() {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_NOTIFICATION_POLICY) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED;
    }

}