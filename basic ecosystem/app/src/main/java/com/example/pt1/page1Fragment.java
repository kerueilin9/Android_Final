package com.example.pt1;

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
import android.widget.Button;
import android.widget.TextView;

import com.example.pt1.databinding.FragmentHomeBinding;
import com.example.pt1.databinding.FragmentPage1Binding;

public class page1Fragment extends Fragment {

    public page1Fragment() {
        // Required empty public constructor
    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewModel1 viewModel1;
        viewModel1 = ViewModelProviders.of(getActivity()).get(ViewModel1.class);
        FragmentPage1Binding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_page1, container, false);
        binding.setData(viewModel1);
        binding.setLifecycleOwner(getActivity());
        //binding.textView2.setText(viewModel1.getNum().toString());
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_page1Fragment_to_homeFragment);
            }
        });
        return binding.getRoot();
        //return inflater.inflate(R.layout.fragment_page1, container, false);
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
//        super.onViewCreated(view, savedInstanceState);
//        Button button = getView().findViewById(R.id.button2);
//        String str = getArguments().getString("key");
//        TextView textView = getView().findViewById(R.id.textView2);
//        textView.setText(str);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavController controller = Navigation.findNavController(view);
//                controller.navigate(R.id.action_page1Fragment_to_homeFragment);
//            }
//        });
//    }
}
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//
//        super.onActivityCreated(savedInstanceState);
//        Button button = getView().findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavController controller = Navigation.findNavController(view);
//                controller.navigate(R.id.action_page1Fragment_to_homeFragment);
//            }
//        });
//    }
