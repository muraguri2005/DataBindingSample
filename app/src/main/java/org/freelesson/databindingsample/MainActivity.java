package org.freelesson.databindingsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import org.freelesson.databindingsample.data.SimpleViewModel;
import org.freelesson.databindingsample.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    SimpleViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(SimpleViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }
}
