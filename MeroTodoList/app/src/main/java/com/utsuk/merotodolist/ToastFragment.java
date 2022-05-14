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
import android.widget.Toast;


public class ToastFragment extends Fragment implements View.OnClickListener {
    Button btnClickme,btnGoogle,btnCallme;
    View view;


    public ToastFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_toast, container, false);
        btnClickme = (Button) view.findViewById(R.id.btnClickme);
        btnCallme = (Button) view.findViewById(R.id.btnCallme);
        btnGoogle = (Button) view.findViewById(R.id.btnGoogle);

        btnClickme.setOnClickListener(this);
        btnCallme.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClickme:

                Toast.makeText(getActivity(),"Thank you for using this मेरो Todo List App. I hope you liked the app and enjoyed it.",Toast.LENGTH_LONG).show();
                break;

            case R.id.btnCallme:
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9860476032")));
                break;

            case R.id.btnGoogle:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:27.6921341,85.3173296 z=3")));
                break;
        }
    }
}