package com.androiddev.petrolstations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.androiddev.petrolstations.databinding.ActivityBottomNavBinding;
import com.androiddev.petrolstations.databinding.ActivityMainBinding;

public class bottom_navActivity extends AppCompatActivity {

    ActivityBottomNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemReselectedListener(item -> {

            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.service:
                    replaceFragment(new PetrolPumpsFragment());
                    break;
                case R.id.speedometer:
                    replaceFragment(new PetrolPumpsFragment());
                    break;
                case R.id.notifiation:
                    replaceFragment(new notificationFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new profileFragment());
                    break;
            }

        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}