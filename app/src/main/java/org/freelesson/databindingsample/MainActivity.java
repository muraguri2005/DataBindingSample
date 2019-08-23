package org.freelesson.databindingsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import org.freelesson.databindingsample.data.SimpleViewModel;
import org.freelesson.databindingsample.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    SimpleViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SimpleViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }
}
