package com.example.basic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setHasOptionsMenu(true);
        ViewModel1 viewModel1;
        viewModel1 = ViewModelProviders.of(getActivity()).get(ViewModel1.class);
        FragmentOneBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);
        binding.setData(viewModel1);
        binding.setLifecycleOwner(getActivity());
        binding.button2.setOnClickListener(view -> {
            String str = binding.editTextTextPersonName.getText().toString();
            if (str.matches("")){
                str = "0";
            }
            viewModel1.getNum().setValue(Integer.parseInt(str));
            NavController controller = Navigation.findNavController(view);
            controller.navigate(R.id.action_oneFragment_to_twoFragment);
        });
        return binding.getRoot();
    }

    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.my_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getActivity(), "item1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(getActivity(), "item2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(getActivity(), "item3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}