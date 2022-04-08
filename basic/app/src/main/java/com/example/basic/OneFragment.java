package com.example.basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.basic.databinding.FragmentOneBinding;

public class OneFragment extends Fragment {

    public OneFragment() {
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
        FragmentOneBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);
        binding.setData(viewModel1);
        binding.setLifecycleOwner(getActivity());
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = binding.editTextTextPersonName.getText().toString();
                if (str.matches("")){
                    str = "0";
                }
                viewModel1.getNum().setValue(Integer.parseInt(str));
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_oneFragment_to_twoFragment);
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_one, container, false);
    }
}