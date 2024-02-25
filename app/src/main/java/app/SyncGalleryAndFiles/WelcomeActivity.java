package app.SyncGalleryAndFiles;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView hoCapito = findViewById(R.id.hoCapito);
        hoCapito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nascondi il bottone
                hoCapito.setVisibility(View.GONE);

                // Passa alla AlertActivity
                startActivity(new Intent(WelcomeActivity.this, AlertActivity.class));
                finish();
            }
        });
    }
}