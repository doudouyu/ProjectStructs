package com.example.administrator.projectstructs.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.view.CameraPreview;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/13.
 */
public class CameraActivity extends BaseActivity {

    private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_camera;
    }

    @Override
    public void initView() {

        if (!checkCameraHardware(this)) {
            return;
        }
        mCamera = getCameraInstance();
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        Button captureButton = (Button) findViewById(R.id.button_capture);
        captureButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // get an image from the camera
                        mCamera.takePicture(null, null, mPicture);
                    }
                }
        );

    }

    @Override
    public void initData() {

    }

    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            File pictureFile = Environment.getExternalStorageDirectory();
//            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            if (pictureFile == null) {
//                Log.d(TAG, "Error creating media file, check storage permissions: " +
//                        e.getMessage());
                return;
            }

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
//                Log.d(TAG, "File not found: " + e.getMessage());

            } catch (IOException e) {
//                Log.d(TAG, "Error accessing file: " + e.getMessage());
            }
        }
    };

    /**
     * A safe way to get an instance of the Camera object.
     * 获得相机示例的正确方法
     */
    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    /**
     * 检查当前的设备中是否有相机
     *
     * @param context
     * @return
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera返回true说明当前的设备中有照相机
            return true;
        } else {
            // no camera on this device返回false说明当前的设备中没有照相机
            return false;
        }
    }
}
