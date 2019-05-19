package shakirul.com.phonecall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dial= findViewById(R.id.Button);
    }

    public void onDialButton(View v){
        Intent intent=new Intent(Intent.ACTION_CALL);
        String dial = "tel:018723";

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_DENIED) {
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
    }
}
