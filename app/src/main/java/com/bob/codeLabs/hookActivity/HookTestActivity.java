package com.bob.codeLabs.hookActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.codeLabs.R;

public class HookTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook_test);
    }

    public void clickToTarget(View view) {
        HookHelper.hookAMSAidl();
        HookHelper.hookHandler();
        startActivity(new Intent(this, TargetActivity.class));
    }
}