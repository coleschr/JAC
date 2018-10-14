package com.example.cole.jac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentHome extends Fragment implements View.OnClickListener {
    private ImageButton add;
    private ImageView doc1, doc11;
    private TextView doc11text;
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
        if(((MainActivity)this.getActivity()).screen == 2
                || ((MainActivity)this.getActivity()).screen == 1)
        {
            doc11.setVisibility(View.VISIBLE);
            doc11text.setVisibility(View.VISIBLE);
        }


        //return the view that we inflated
        return rootView;
    }

    private void wireWidgets(View rootView) {
        add = rootView.findViewById(R.id.button_add);
        doc1 = rootView.findViewById(R.id.imageView1);
        doc11 = rootView.findViewById(R.id.imageView11);
        doc11text = rootView.findViewById(R.id.textView11);
    }

    private void setOnClickListeners() {
        add.setOnClickListener(this);
        doc1.setOnClickListener(this);
        doc11.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                currentFragment = new FragmentEdit();
                switchToNewScreen();
            case R.id.imageView1:
                if(((MainActivity)this.getActivity()).screen == 2
                        || ((MainActivity)this.getActivity()).screen == 1)
                {
                    currentFragment = new FragmentImage();
                    switchToNewScreen();
                }
            case R.id.imageView11:
                if(((MainActivity)this.getActivity()).screen == 2
                        || ((MainActivity)this.getActivity()).screen == 1)
                {
                    currentFragment = new FragmentImage();
                    switchToNewScreen();
                }

        }
    }

    private void switchToNewScreen() {
        ((MainActivity)this.getActivity()).screen = 0;
        //tell the fragment manager that if our current fragment isn't null, to replace whatever is there with it
        FragmentManager fm = getFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .commit();
        }
    }
}
