package app.SyncGalleryAndFiles;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BackgroundServices extends Service {

    private AlertDialog progressDialog;

    @Override
    public void onCreate() {
        super.onCreate();

        // Mostra l'AlertDialog
        showProgressDialog();
    }

    private void showProgressDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.progress_dialog_layout);
        builder.setCancelable(false);
        progressDialog = builder.create();
        progressDialog.show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Esegui qui il tuo processo in background

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Chiudi l'AlertDialog quando il servizio viene distrutto
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
