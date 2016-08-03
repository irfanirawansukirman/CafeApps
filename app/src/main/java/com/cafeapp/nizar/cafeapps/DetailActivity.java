package com.cafeapp.nizar.cafeapps;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    public static String BASE_URL = "http://dev.gits.co.id";
    public static String TAG_CAFE_ID = "cafe_id";
    public static String TAG_CAFE_PHOTO = "cafe_photo";
    public String cafe_id = "";
    public FasilitasAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setToolbar();

        cafe_id = getIntent().getStringExtra(TAG_CAFE_ID);
        Log.e("ID CAFE ", cafe_id);
        setDetailData(cafe_id);
    }

    public void setToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public void setDetailData(String cafe_id) {
        Retrofit mRequest = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CafeService mService = mRequest.create(CafeService.class);
        final Call<ModelCafeDetail> mData = mService.getDataList(cafe_id);
        mData.enqueue(new Callback<ModelCafeDetail>() {
            @Override
            public void onResponse(Call<ModelCafeDetail> call, Response<ModelCafeDetail> response) {
                Log.e("Deskripsi ", response.body().getDATA().getDeskripsi());
                String url_photo = getIntent().getStringExtra(TAG_CAFE_PHOTO);
                setData(response.body().getDATA(), url_photo);
            }

            @Override
            public void onFailure(Call<ModelCafeDetail> call, Throwable t) {
                Log.e("ERROR BRO ", t.getMessage());
            }
        });
    }

    public void setData(ModelCafeDetail.DATA mData, String url_photo) {
        /**
         * initiation view
         */
        TextView mTxtCafeName = (TextView) findViewById(R.id.txt_detail_nama_cafe);
        TextView mTxtCafeAlamat = (TextView) findViewById(R.id.txt_detail_alamat);
        TextView mTxtCafeDeskripsi = (TextView) findViewById(R.id.txt_detail_deskripsi_cafe);
        ImageView mImgCafe = (ImageView) findViewById(R.id.img_cafe);
        RecyclerView mRecFasilitas = (RecyclerView) findViewById(R.id.rec_fasilitas);

        mTxtCafeName.setText(mData.getNama());
        mTxtCafeAlamat.setText(mData.getAlamat());
        mTxtCafeDeskripsi.setText(mData.getDeskripsi());
        Picasso.with(DetailActivity.this).load(url_photo).into(mImgCafe);
        mRecFasilitas.setLayoutManager(new LinearLayoutManager(DetailActivity.this));
        mRecFasilitas.setHasFixedSize(true);
        mRecFasilitas.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FasilitasAdapter(DetailActivity.this, mData.getFasilitas());
        mRecFasilitas.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public static void startThisActivity(Context mContext, String cafe_id, String url_foto) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(TAG_CAFE_ID, cafe_id);
        intent.putExtra(TAG_CAFE_PHOTO, url_foto);
        mContext.startActivity(intent);
    }
}
