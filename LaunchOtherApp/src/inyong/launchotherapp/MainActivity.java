package inyong.launchotherapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity implements OnClickListener
{

//buat objek Button/tombol (ane namai tombolMasukSetting)
Button tombolMasukSetting;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		// Hal standart yg pertama dijalankan saat app dijalankan
		// adalah menampilkan xml layout utama (res/layout/main.xml) layout utama
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		// inisialisasi tombol
		tombolMasukSetting=(Button) findViewById(R.id.tombol_masuk_setting);
		tombolMasukSetting.setOnClickListener(this);
	
    }
	//method untuk mendeteksi saat ada yg diclick
	public void onClick(View v){
		masukSetting();
	}
	
	
	//method masuk setting
	public void masukSetting(){
		Intent i = getPackageManager().getLaunchIntentForPackage("com.android.settings");
		startActivity(i);
	}
}
