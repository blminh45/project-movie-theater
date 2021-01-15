package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.BankViewHolder> {
    private final LinkedList<String> mBankList;
    private LayoutInflater mInflater;

    public BankListAdapter(Context context, LinkedList<String> lst) {
        mInflater = LayoutInflater.from(context);
        this.mBankList = lst;
    }

    @NonNull
    @Override
    public BankListAdapter.BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_bank,
                parent, false);
        return new BankViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull BankListAdapter.BankViewHolder holder, int position) {
        String mCurrent = mBankList.get(position);
        holder.bankItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BankViewHolder extends RecyclerView.ViewHolder {
        public final TextView bankItemView;
        final BankListAdapter mAdapter;
        public BankViewHolder(@NonNull View itemView, BankListAdapter mAdapter) {
            super(itemView);
            this.bankItemView = itemView.findViewById(R.id.bank_item);
            this.mAdapter = mAdapter;
        }
    }
}
