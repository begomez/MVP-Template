package com.bernatgomez.apps.template.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bernatgomez.apps.template.R;
import com.bernatgomez.apps.template.navigation.Navigator;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void launchContentFragment() {
        super.launchContentFragment();

        Navigator.launchFragment(this, CONTAINER_ID, MainFragment.newInstance());
    }
}
