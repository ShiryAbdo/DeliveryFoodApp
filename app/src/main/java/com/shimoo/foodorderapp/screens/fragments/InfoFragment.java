package com.shimoo.foodorderapp.screens.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.shimoo.foodorderapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InfoFragment extends Fragment {
    @BindView(R.id.Contact) TextView Contact;
    @BindView(R.id.linkedin_button) ImageView linkedin_button;
    @BindView(R.id.github_button) ImageView github_button;
    @BindView(R.id.gmail_button) ImageView gmail_button;
    private static final int REQUEST_PHONE_CALL = 1;
    View rooteView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rooteView = inflater.inflate(R.layout.profile_main, container, false);
        ButterKnife.bind(this,rooteView);
          getActivity().setTitle("");
        getActivity().findViewById(R.id.toolbar).setBackgroundColor(Color.TRANSPARENT);
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("01210387863");


            }
        });
        linkedin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.linkedin.com/in/shimaa-abdo-052008106"));
                getActivity().startActivity(i);

            }
        });
        gmail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] reciever = new String[]{"shimaawork84@gmail.com"};
                String subject = ("Feedback/Question");
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.putExtra(Intent.EXTRA_EMAIL, reciever);
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                 mailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(mailIntent, "Choose an application to send your mail with"));

            }
        });

        github_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/ShiryAbdo"));
                getActivity().startActivity(i);

            }
        });

        return  rooteView ;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_CALL : {
                Toast.makeText(getActivity(), "shimoo", Toast.LENGTH_SHORT).show();

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    call("01210387863");
                }else {
                    call("01210387863");

                }
            }
        }
    }


    public void call(String s) {


        if (ActivityCompat.checkSelfPermission(getActivity().getBaseContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_PHONE_CALL);
            return;
        }else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+s));
            startActivity(callIntent);

        }

    }


}
