package com.andresapps.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.andresapps.myapp.models.SectionModel;
import com.andresapps.myapp.fragments.PlaceholderFragment;
import com.andresapps.myapp.adapters.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        FloatingActionButton fab = findViewById(R.id.fab);
        TabLayout tabs = findViewById(R.id.tabs);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager(), 0);

        String json = null;

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.json);

            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            json = new String(b);
        } catch (Exception ignored) {
            Toast.makeText(this, getString(R.string.error_read), Toast.LENGTH_SHORT).show();
        }

        if (json != null) {
            try {
                JSONArray json_array = new JSONArray(json);

                for (int i = 0; i < json_array.length(); i++) {
                    SectionModel model = new SectionModel(json_array.getJSONObject(i));
                    adapter.addFragment(new PlaceholderFragment(), model.getName(), model);
                }
            } catch (JSONException e) {
                SectionModel model = new SectionModel(getString(R.string.error_parse));
                adapter.addFragment(new PlaceholderFragment(), "0", model);
            }
        } else {
            SectionModel model = new SectionModel(getString(R.string.error_read));
            adapter.addFragment(new PlaceholderFragment(), "0", model);
        }

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.web_page), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.go), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String url = "https://bedu.org/cursos/desarrollo-mobile-con-java/";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                        }).show();
            }
        });
    }
}