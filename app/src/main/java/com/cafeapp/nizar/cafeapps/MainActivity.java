package com.cafeapp.nizar.cafeapps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ListAdapter.detailListerner, SwipeRefreshLayout.OnRefreshListener{
    public static String BASE_URL = "http://dev.gits.co.id";
    public List<ModelCafe.DATA> mDataModel = new ArrayList<>();
    public Context mContext = this;
    public ListAdapter mAdapter;
    public RecyclerView mRecyclerView;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        mRecyclerView = (RecyclerView) findViewById(R.id.rec_menu_cafe);

        setList();
        mRecyclerView.addOnItemTouchListener(new RecyclerViewItemClickListener(MainActivity.this, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                DetailActivity.startThisActivity(MainActivity.this, mDataModel.get(position).getId(), mDataModel.get(position).getUrl_foto());
            }
        }));

//        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                setList();
//            }
//        });
    }

    public void setList() {
        Retrofit mRequest = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CafeService mService = mRequest.create(CafeService.class);
        final Call<ModelCafe> mData = mService.getDataList();
        mData.enqueue(new Callback<ModelCafe>() {
            @Override
            public void onResponse(Call<ModelCafe> call, Response<ModelCafe> response) {
                mDataModel.clear();
                mDataModel.addAll(response.body().getDATA());
                mAdapter = new ListAdapter(mContext, mDataModel, MainActivity.this);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
//                Log.e("LATITUDE ", response.body().getDATA().get(0).getLocation().getLatitude().toString().replace("[","").replace("]",""));
//                Log.e("LONGITUDE ", response.body().getDATA().get(0).getLocation().getLongitude().toString().replace("[","").replace("]",""));
            }

            @Override
            public void onFailure(Call<ModelCafe> call, Throwable t) {
                Log.e("ERROR BRO ", t.getMessage());
            }
        });
    }

    @Override
    public void onItemClickListener(int position, ModelCafe.DATA mData) {
        Log.e("NAMA ", mData.getNama());
    }

    @Override
    public void onRefresh() {
//        setList();
    }
}
