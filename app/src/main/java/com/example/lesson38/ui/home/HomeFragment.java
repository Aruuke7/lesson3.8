package com.example.lesson38.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson38.R;
import com.example.lesson38.adapter.DrugsAdapter;
import com.example.lesson38.databinding.FragmentHomeBinding;
import com.example.lesson38.model.Drugs;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements DrugsAdapter.OnItemClickListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private ArrayList<Drugs> list;
    private DrugsAdapter adapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = binding.recyclerViewHome;
        adapter = new DrugsAdapter(new DrugsAdapter.OnItemClickListener() {
            @Override
            public void OnClick(Drugs drugs) {

            }
        });
        adapter.updateData(addList(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private ArrayList<Drugs> addList() {
        list = new ArrayList<>();
        list.add(new Drugs(Drugs.LayoutOne,"Сердечно-сосудистая система"));
        list.add(new Drugs(Drugs.LayoutTwo,"Б- блокаторы","Бисопролол",R.drawable.img));
        list.add(new Drugs(Drugs.LayoutTwo,"Ингибиторы АПФ","Периндоприл",R.drawable.img));
        list.add(new Drugs(Drugs.LayoutTwo,"Сартаны","Валсартан",R.drawable.img));
        list.add(new Drugs(Drugs.LayoutOne,"Дыхательная система"));
        list.add(new Drugs(Drugs.LayoutTwo,"Муколитики","Амброксол",R.drawable.img));
        list.add(new Drugs(Drugs.LayoutTwo,"Отхаркивающие вещества","Корень Солодки",R.drawable.img));
        list.add(new Drugs(Drugs.LayoutOne,"Эндокринная система"));
        list.add(new Drugs(Drugs.LayoutTwo,"Препараты йода","калия йодид",R.drawable.img));


        return list;
    }

    @Override
    public void OnClick(Drugs drugs) {

    }
}