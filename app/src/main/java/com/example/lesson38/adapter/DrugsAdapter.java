package com.example.lesson38.adapter;

import static com.example.lesson38.model.Drugs.LayoutOne;
import static com.example.lesson38.model.Drugs.LayoutTwo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lesson38.databinding.ItemRecyclerFirstBinding;
import com.example.lesson38.databinding.ItemRecyclerSecondBinding;
import com.example.lesson38.model.Drugs;

import java.util.ArrayList;

public class DrugsAdapter extends RecyclerView.Adapter {


    private ArrayList<Drugs> list = new ArrayList<>();
    private ItemRecyclerFirstBinding homeBinding;
    private ItemRecyclerSecondBinding settingBinding;
    private OnItemClickListener listener;

    public DrugsAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(ArrayList<Drugs> list, OnItemClickListener listener){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case LayoutOne:
                homeBinding = ItemRecyclerFirstBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new LayoutOneViewHolder(homeBinding);
            case LayoutTwo:
                settingBinding = ItemRecyclerSecondBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new LayoutTwoViewHolder(settingBinding);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (list.get(position).getViewType()) {
            case LayoutOne:
                String text = list.get(position).getDisease();
                homeBinding.text.setText(text);
                homeBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(),list.get(position).getDisease(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case LayoutTwo:
                int image = list.get(position).getIcon();
                String text_one = list.get(position).getGroup();
                String text_two = list.get(position).getDrug();
                settingBinding.image.setImageResource(image);
                settingBinding.textOne.setText(text_one);
                settingBinding.textTwo.setText(text_two);
                settingBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(),list.get(position).toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                return;
        }
    }


    public int getItemViewType(int position)
    {
        switch (list.get(position).getViewType()) {
            case 0:
                return LayoutOne;
            case 1:
                return LayoutTwo;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class LayoutOneViewHolder extends RecyclerView.ViewHolder {
        public LayoutOneViewHolder(@NonNull ItemRecyclerFirstBinding itemView) {
            super(itemView.getRoot());
            itemView = homeBinding;
        }
    }

    private class LayoutTwoViewHolder extends RecyclerView.ViewHolder {
        public LayoutTwoViewHolder(@NonNull ItemRecyclerSecondBinding itemView) {
            super(itemView.getRoot());
            itemView = settingBinding;
        }
    }
    public  interface OnItemClickListener{
        void OnClick(Drugs drugs);
    }
}
