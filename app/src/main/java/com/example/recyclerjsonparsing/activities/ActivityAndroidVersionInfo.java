package com.example.recyclerjsonparsing.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerjsonparsing.R;
import com.example.recyclerjsonparsing.models.AndroidVersion;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityAndroidVersionInfo extends AppCompatActivity {

    private AndroidVersion androidVersion;
    private static final String ANDROID_VERSN = "Android Version";

    @BindView(R.id.toolbarIntent)
    Toolbar toolbar;

    @BindView(R.id.textViewIntent)
    TextView textView;

    @BindView(R.id.imageViewIntent)
    ImageView imageView;

    @BindView(R.id.toolbar_textViewIntent)
    TextView textViewTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_version_info);

        ButterKnife.bind(this);

        androidVersion = (AndroidVersion) getIntent().getSerializableExtra(ANDROID_VERSN);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_left_thick);
            textViewTool.setText(androidVersion.getName());
        }

        showSelectedItem(androidVersion);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showSelectedItem(AndroidVersion androidVersion){
        textView.setText(androidVersion.getVersion());
    }



}
