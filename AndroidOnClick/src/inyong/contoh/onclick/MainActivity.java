package inyong.contoh.onclick;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	//method sesuai dengan yg ada di xml (androi:onClick)
	public void masukSettings(View v){
		jalankanAplikasiLain("com.android.settings");
	}
	
	public void masukGalery(View v){
		jalankanAplikasiLain("com.alensw.PicFolder");
	}
	
	public void masukPhoneBook(View v){
		jalankanAplikasiLain("com.android.contoh.salah.nulis");
	}
	
	// fungsi untuk menjalankan aplikasi lain
	private void jalankanAplikasiLain(String namaPackageTujuan){
		Intent i = getPackageManager().getLaunchIntentForPackage(namaPackageTujuan);
		if(i != null){
			startActivity(i);
		}else{
			Toast.makeText(this, "Inyong tidak menemukan folder\n\""+namaPackageTujuan+"\"", Toast.LENGTH_LONG).show();
		}
	}
}
