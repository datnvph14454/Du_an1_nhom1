package com.poly.testgit.ui.video;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poly.testgit.R;
import com.poly.testgit.databinding.FragmentSlideshowBinding;
import com.poly.testgit.databinding.FragmentVideoFragmentBinding;
import com.poly.testgit.ui.slideshow.SlideshowViewModel;

public class FragmentVideo extends Fragment {

    private FragmentVideoViewModel videoViewModel;
    private FragmentVideoFragmentBinding binding;

    public static FragmentVideo newInstance() {
        return new FragmentVideo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        videoViewModel =
                new ViewModelProvider(this).get(FragmentVideoViewModel.class);

        binding = FragmentVideoFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVideo;
        videoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}