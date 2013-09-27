package inyong.launchotherapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity implements OnClickListener
{

//buat objek Button/tombol (ane namai tombolMasukSetting dan tombolMasukFireTools)
	Button tombolMasukSetting, tombolMasukFireTools;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		// Hal standart yg pertama dijalankan saat app dijalankan
		// adalah menampilkan xml layout utama (res/layout/main.xml) layout utama
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		// inisialisasi tombol
		tombolMasukSetting = (Button) findViewById(R.id.id_tombol_masuk_setting);
		// pasang clicklistener supaya bisa diclick
		tombolMasukSetting.setOnClickListener(this);

		tombolMasukFireTools = (Button) findViewById(R.id.id_tombol_masuk_firetool);
		tombolMasukFireTools.setOnClickListener(this);
    }
	//method untuk mendeteksi saat ada yg diclick
	public void onClick(View v)
	{
		// fungsi switch untuk perpindah atara smua kemungkinan sampai didapati salah satu yg dicari
		switch (v.getId())
		{
			case R.id.id_tombol_masuk_setting:
				//jika id tombol yg diklik adlh id tombol masuk seting, maka jalankan fungsi masuk seting
				// jika idnya bukan itu, lanjut ke fungsi switch berikutnya
				jalankanAplikasiLain("com.android.settings");
				// stop fungsi switch saat salah satu id terbaca
				break;

			case R.id.id_tombol_masuk_firetool:
				jalankanAplikasiLain("inyong.xt530.tools");
				break;

			default: 
				break;
		}
	}


	//method untuk menjalankan aplikasi lain
	// dengan parameter nama folder data /packagename dari app yg mau dijalankan
	public void jalankanAplikasiLain(String namaFolderData)
	{
		Intent i = getPackageManager().getLaunchIntentForPackage(namaFolderData);
		if (i != null) // jika i (intent) tidak null (tidak kosong)
		// berarti aplikasi dgn namafolderdata dimaksud ditemukan
		{
			// maka jalankan app tsb.
			startActivity(i);
		}
		else
		{ 
			// sebaliknya aplikasi gak ada
			// kita akan coba tampilin dialog ke user
			// memberitahukan bahwa app dgn nama folder data dimaksud gak ditemukan
			dialogErrorFolderTidakDitemukan(namaFolderData);
		}
	}


	//code dialog error ditulis dalam method berbeda agar tdk terlalu ruwet
	public void dialogErrorFolderTidakDitemukan(String namaFolder)
	{
		AlertDialog.Builder d = new AlertDialog.Builder(this);
		d.setMessage("Ups...\n Inyong tidak menemukan aplikasi dengan folder data \n\"" + namaFolder+"\"");
		d.setCancelable(true); // agar dialog bisa ditutup dengn tombol back
		d.show(); // perintah agar dialog tampil
	}
}
