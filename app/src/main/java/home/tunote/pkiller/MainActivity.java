package home.tunote.pkiller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String TAG = "PKill";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.kill_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Process process = Runtime.getRuntime().exec(new String[] {"su", "-c", "killall", "system_server"});
                } catch (IOException e) {
                    Log.e(TAG, "No SuperUser rights!");
                }
            }
        });
    }
}
