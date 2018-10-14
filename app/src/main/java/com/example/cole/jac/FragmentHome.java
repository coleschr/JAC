package com.example.cole.jac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FragmentHome extends Fragment implements View.OnClickListener {
    private ImageButton add;
    private Fragment currentFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);
        setOnClickListeners();

        //get any other initial set up done


        //return the view that we inflated
        return rootView;
    }

    private void wireWidgets(View rootView) {
        add = rootView.findViewById(R.id.button_add);
    }

    private void setOnClickListeners() {
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                currentFragment = new FragmentCamera();
                switchToNewScreen();
                break;
        }
    }

    private void switchToNewScreen() {
        //tell the fragment manager that if our current fragment isn't null, to replace whatever is there with it
        FragmentManager fm = getFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .commit();
        }
    }
}
