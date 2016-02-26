package com.teknorial.retrofit2listview;

import android.app.ProgressDialog;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.teknorial.retrofit2listview.models.Listbuku;
import com.teknorial.retrofit2listview.models.Model;
import com.teknorial.retrofit2listview.rest.RestAPI;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
   //root url dari webservice
    public static final String ROOT_URL = "http://api.teknorial.com/";
   //deklarasi varibel untuk mengirim data ke activity lain
    public static final String ID_BUKU = "book_id";
    public static final String NAMA_BUKU = "nama_buku";
    public static final String HARGA_BUKU = "harga_buku";
    public static final String STATUS_BUKU = "status_buku";
    //listview untuk menampilkan data
    private ListView listview;
    //varibel books bertipe List dan List tersebut berdasarkan objek Listbuku
    private List<Listbuku> books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inisialisasi listview
        listview = (ListView) findViewById(R.id.listViewBuku);

        //memanggil method untuk mengambil data buku
        getBuku();

        //setting onItemClickListener untuk listview
        listview.setOnItemClickListener(this);


    }

    private void getBuku() {
        //Ketika Aplikasi mengambil data kita akan melihat progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please Wait..",false,false);
        //Logging Interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //set Level Log
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())//GsonConverter untuk parsing json
                .client(httpClient.build())
                .build();

                RestAPI service = retrofit.create(RestAPI.class);

                Call<Model> call = service.loadListBook();
                call.enqueue(new Callback<Model>() {  //Asyncronous Request
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        loading.dismiss();
                        List<Listbuku> buku = response.body().getListbuku();

                //memasukkan data dari varibel buku ke books
                books = buku;
                //memanggil method untuk menampilkan list
                showList();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    private void showList() {
        //String array untuk menyimpan nama semua nama buku
        String[] items = new String[books.size()];

        for (int i = 0; i < books.size(); i++) {

            items[i] = books.get(i).getNama();
        }
        //Membuat Array Adapter for listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, items);

        //setting adapter untuk listview
        listview.setAdapter(adapter);

    }

    //method ini akan dieksekusi ketikan listitem diklik
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //membuat intent
        Intent intent = new Intent(this, LihatDetailBuku.class);
        //mengambil buku dari list
        Listbuku listbuku = books.get(position);
        //menambahkan detail buku untuk intent
        intent.putExtra(ID_BUKU, listbuku.getIdbuku());
        intent.putExtra(NAMA_BUKU, listbuku.getNama());
        intent.putExtra(HARGA_BUKU, listbuku.getHarga());
        intent.putExtra(STATUS_BUKU, listbuku.getStatus());

        //memulai activity lain untuk menampilkan detail buku
        startActivity(intent);

    }




}
