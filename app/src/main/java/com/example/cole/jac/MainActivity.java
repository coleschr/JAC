package com.example.cole.jac;

import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int screen;
    private Fragment currentFragment;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wireWidgets();
        setUpHomeScreen();
    }

    private void wireWidgets() {
        layout = findViewById(R.id.layout_main_background);
    }

    private void setUpHomeScreen() {
        screen = 0;
        currentFragment = new FragmentHome();
        switchToNewScreen();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            layout.setBackgroundColor(getColor(R.color.colorBackground));
        } else { //#212121
            layout.setBackgroundColor(Color.rgb(33, 33, 33));
        }
    }

    private void switchToNewScreen() {
        //tell the fragment manager that if our current fragment isn't null, to replace whatever is there with it
        FragmentManager fm = getSupportFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .commit();
        }
    }
}
