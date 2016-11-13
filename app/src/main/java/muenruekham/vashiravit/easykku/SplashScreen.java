package muenruekham.vashiravit.easykku;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // Sound Effect
        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.intro_tata);  // เปลี่ยนเสียง
        mediaPlayer.start();

        // Auto Intend
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, 9000); // หน่วงเวลา



    } // Main method


} // Main Class
