package com.raonsecure.jetpack;

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
import androidx.fragment.app.*;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.raonsecure.jetpack.databinding.FragmentFirstBinding;
import com.raonsecure.jetpack.room.AppDatabase;
import com.raonsecure.jetpack.room.User;


public class FirstFragment extends Fragment {

    final static String TAG = "AndroidX";

    private FragmentFirstBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "FirstFragment");

//        View view = inflater.inflate(R.layout.fragment_first, container, false);
//        return super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.buttonDialog.setOnClickListener((v)-> {

            new Thread(() -> {
                User user = new User("1","park","dong jun");
                AppDatabase.getInstance(getActivity()).userDao().insert(user);

                user = AppDatabase.getInstance(getActivity()).userDao().findByName("park","dong jun");
                Log.d(TAG, "FirstFragment id: "+user.getUid()+" firstName: "+user.getFirstName()+ " lastName: "+user.getLastName());
            }).start();
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonNext.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondFragment);
        });
    }
}
