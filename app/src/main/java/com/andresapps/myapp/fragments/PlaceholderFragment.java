package com.andresapps.myapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.andresapps.myapp.R;
import com.andresapps.myapp.utils.Const;

public class PlaceholderFragment extends Fragment {

    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (getContext() != null) {
            context = getContext();
        }

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView txvName = rootView.findViewById(R.id.txvName);
        TextView txvVersion = rootView.findViewById(R.id.txvVersion);
        TextView txvYear = rootView.findViewById(R.id.txvYear);
        TextView txvFeatures = rootView.findViewById(R.id.txvFeatures);
        ImageView imvLogo = rootView.findViewById(R.id.imvLogo);

        if (getArguments() != null) {
            txvName.setText(getArguments().getString(Const.KEY_NAME));

            String version = getString(R.string.version) + ": " + getArguments().getString(Const.KEY_VERSION);
            txvVersion.setText(version);

            txvYear.setText(getArguments().getString(Const.KEY_YEAR));
            txvFeatures.setText(Html.fromHtml(getArguments().getString(Const.KEY_FEATURES)));

            String resId = getArguments().getString(Const.KEY_IMAGE, "-1");
            if (!resId.equals("-1")) {
                imvLogo.setImageResource(getResources().getIdentifier(resId, "drawable", context.getPackageName()));
            }
        }

        return rootView;
    }
}