package com.cafeapp.nizar.cafeapps;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irfan on 02/08/16.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    public Context mContext;
    public List<ModelCafe.DATA> mData = new ArrayList<>();
    public ModelCafe.DATA mItem;
    public detailListerner mListerner;

    public ListAdapter(Context mContext, List<ModelCafe.DATA> mData, detailListerner mListerner) {
        this.mContext = mContext;
        this.mData = mData;
        this.mListerner = mListerner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cafe_row, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        mItem = mData.get(position);
        holder.mTxtCafe.setText(mItem.getNama());
        holder.mTxtAlamat.setText(mItem.getAlamat());
        Picasso.with(mContext).load(mItem.getUrl_foto()).into(holder.mImgCafe);

        holder.mCardRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListerner.onItemClickListener(position, mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxtCafe;
        public TextView mTxtAlamat;
        public ImageView mImgCafe;
        public CardView mCardRow;

        public MyViewHolder(View itemView) {
            super(itemView);
            mCardRow = (CardView) itemView.findViewById(R.id.card_row);
            mTxtCafe = (TextView) itemView.findViewById(R.id.txt_nama_cafe);
            mTxtAlamat = (TextView) itemView.findViewById(R.id.txt_alamat);
            mImgCafe = (ImageView) itemView.findViewById(R.id.img_cafe);
        }
    }

    public interface detailListerner{
        void onItemClickListener(int position, ModelCafe.DATA mData);
    }
}
