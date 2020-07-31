package com.raonsecure.jetpack;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.*;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.raonsecure.jetpack.databinding.FragmentSecondBinding;
import com.raonsecure.jetpack.viewmodel.CounterCallback;
import com.raonsecure.jetpack.viewmodel.CounterViewModel;


public class SecondFragment extends Fragment  {

    final static String TAG = "AndroidX";

    private FragmentSecondBinding binding;

    private CounterViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "SecondFragment");

        binding = FragmentSecondBinding.inflate(inflater, container, false);
//        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_second);
//        binding.setSecondFragment(this);
        //이 객체가 이 액티비티의 라이프사이클을 참조하면서 데이터가 변경되거나 하면
        binding.setLifecycleOwner(this);

        //ViewModel 가져오기
        viewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        binding.setViewModel(viewModel);

//        binding.textviewNumber.setText(viewModel.counter + " ");

        // LiveData 사용
//        viewModel.cnt.observe(getViewLifecycleOwner(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.textviewNumber.setText(integer + "");
//            }
//        });

        return binding.getRoot();
    }

//    public void onAddButtonClick() {
//        Log.d(TAG, "onAddButtonClick");
////        viewModel.counter++;
////        binding.textviewNumber.setText(viewModel.counter + " ");
//
//        viewModel.increase();
//    }

//    public void onSubButtonClick() {
//        Log.d(TAG, "onSubButtonClick");
////        viewModel.counter--;
////        binding.textviewNumber.setText(viewModel.counter + " ");
//        viewModel.decrease();
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_mainFragment);
        });


    }
}
