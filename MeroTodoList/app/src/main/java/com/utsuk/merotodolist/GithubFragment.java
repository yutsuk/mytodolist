package com.utsuk.merotodolist;
/*
 * Utsuk Paudayal
 * C7227233
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GithubFragment extends Fragment implements View.OnClickListener {
    Button btnGit;
    View view;

    public GithubFragment() {
        // Required empty public constructor
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_github, container, false);
        btnGit = (Button) view.findViewById(R.id.btnGit);
        btnGit.setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        //do what you want to do when button is clicked
        switch (v.getId()) {
            case R.id.btnGit:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/yutsuk/merotodolist.git")));
                break;
        }
    }


}