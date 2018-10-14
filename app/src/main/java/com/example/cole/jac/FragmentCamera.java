package com.example.cole.jac;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentCamera extends Fragment implements View.OnClickListener {
    private ImageView capture, camera_image;
    private Fragment currentFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.camera_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);
        setOnClickListeners();

        //get any other initial set up done
        ((MainActivity)this.getActivity()).screen = 1;

        /*CameraManager cameraManager = (CameraManager) getActivity().getSystemService(CAMERA_SERVICE);
        try {
            for (String cameraId : cameraManager.getCameraIdList()) {
                CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
                Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                if (facing != null && facing.equals(CameraCharacteristics.LENS_FACING_FRONT)) {

                }
                // Do something with the characteristics
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }*/

        //return the view that we inflated
        return rootView;
    }

    private void wireWidgets(View rootView) {
        capture = rootView.findViewById(R.id.imageView_capture);
        camera_image = rootView.findViewById(R.id.imageView_camera);
    }

    private void setOnClickListeners() {
        capture.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_capture:


                currentFragment = new FragmentEdit();
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
