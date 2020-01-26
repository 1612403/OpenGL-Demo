package com.example.opengldemo;

import androidx.appcompat.app.AppCompatActivity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    GLSurfaceView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        view = new GLSurfaceView(this);
        view.setRenderer(new ShapeRenderer());
        setContentView(view);
    }
    @Override
    protected void onPause() {
        super.onPause();
        view.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.onResume();
    }
}
