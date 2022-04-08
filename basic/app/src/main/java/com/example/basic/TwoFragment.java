package com.example.basic;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basic.databinding.FragmentOneBinding;
import com.example.basic.databinding.FragmentTwoBinding;

public class TwoFragment extends Fragment {

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewModel1 viewModel1;
        viewModel1 = ViewModelProviders.of(getActivity()).get(ViewModel1.class);
        FragmentTwoBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false);
        binding.setData(viewModel1);
        binding.setLifecycleOwner(getActivity());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_twoFragment_to_oneFragment);
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_two, container, false);
    }
}