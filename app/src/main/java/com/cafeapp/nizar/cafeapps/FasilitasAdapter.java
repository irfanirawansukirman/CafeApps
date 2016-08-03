package com.cafeapp.nizar.cafeapps;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irfan on 03/08/16.
 */
public class FasilitasAdapter extends RecyclerView.Adapter<FasilitasAdapter.MyViewHolder> {
    public Context mContext;
    public List<ModelCafeDetail.FASILITAS> mData = new ArrayList<>();
    public ModelCafeDetail.FASILITAS mItem;

    public FasilitasAdapter(Context mContext, List<ModelCafeDetail.FASILITAS> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fasilitas_row, parent, false);
        MyViewHolder mHolder = new MyViewHolder(mView);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mItem = mData.get(position);
        holder.mTxtFasilitas.setText(mItem.getNama());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtFasilitas;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTxtFasilitas = (TextView) itemView.findViewById(R.id.txt_fasilitas);
        }
    }
}
