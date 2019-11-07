package com.andresapps.myapp.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.andresapps.myapp.models.SectionModel;
import com.andresapps.myapp.utils.Const;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> list = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void addFragment(Fragment fragment, String title, SectionModel model) {
        Bundle bundle = new Bundle();
        bundle.putString(Const.KEY_NAME, model.getName());
        bundle.putString(Const.KEY_VERSION, model.getVersion());
        bundle.putString(Const.KEY_IMAGE, model.getImgSrc());
        bundle.putString(Const.KEY_YEAR, model.getYear());
        bundle.putString(Const.KEY_FEATURES, model.getFeatures());

        fragment.setArguments(bundle);

        list.add(fragment);
        titles.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
