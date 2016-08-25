package com.offlinestorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageLoader imageLoader;
    private EditText imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imageHolder);
        imageLoader = new ImageLoader(this);
    }

    public void btnLoadImage(View v) {
        imageUrl = (EditText) findViewById(R.id.imageUrl);
        imageLoader.displayImage(imageUrl.getText().toString(), imageView);
    }
}
