package com.example.pt1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pt1.databinding.ActivityMainBinding;
import com.example.pt1.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewModel1 viewModel1;
        viewModel1 = ViewModelProviders.of(getActivity()).get(ViewModel1.class);
        FragmentHomeBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setData(viewModel1);
        binding.setLifecycleOwner(getActivity());
        binding.button123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel1.getNum().setValue(Integer.parseInt(binding.editTextNumber.getText().toString()));

                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_homeFragment_to_page1Fragment);
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_home, container, false);
    }


//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ActivityMainBinding binding;
//        Button button = getView().findViewById(R.id.button);
////        EditText edt = getView().findViewById(R.id.editTextNumber);
////        String str = edt.getText().toString();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                EditText edt = getView().findViewById(R.id.editTextNumber);
//                String str = edt.getText().toString();
//                if (TextUtils.isEmpty(str)){
//                    Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                Bundle bundle = new Bundle();
//                bundle.putString("key", str);
//
//                NavController controller = Navigation.findNavController(view);
//                controller.navigate(R.id.action_homeFragment_to_page1Fragment, bundle);
//            }
//        });
//    }

}


//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//
//        super.onActivityCreated(savedInstanceState);
//        ActivityMainBinding binding;
//        Button button = getView().findViewById(R.id.button);
//        EditText edt = getView().findViewById(R.id.editTextTextPersonName);
//        String str = edt.getText().toString();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (TextUtils.isEmpty(str)) {
//                    Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                Bundle bundle = new Bundle();
//                bundle.putString("key", str);
//
//                NavController controller = Navigation.findNavController(view);
//                controller.navigate(R.id.action_homeFragment_to_page1Fragment, bundle);
//            }
//        });
//    }

//    Button button = getView().findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        NavController controller = Navigation.findNavController(view);
//        controller.navigate(R.id.action_homeFragment_to_page1Fragment);
//        }
//        });