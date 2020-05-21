package ie.bim.myapplication.ui.other;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import ie.bim.myapplication.R;
import ie.bim.myapplication.ui.welcome.ResetPassActivity;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_settings, container, false);
        layout.findViewById(R.id.enableStorage).setOnClickListener(
                view -> {
                    if(ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(this.getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                1);


                    }

                }
        );
        layout.findViewById(R.id.enableMic).setOnClickListener(
                view -> {
                    if(ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(this.getActivity(),new String[]{Manifest.permission.RECORD_AUDIO},
                                1);


                    }

                }
        );

        layout.findViewById(R.id.resetPassSettings).setOnClickListener(view ->
    {
            Intent resetactivity = new Intent(getContext(), ResetPassActivity.class);
            startActivity(resetactivity);
        });

        // Inflate the layout for this fragment
        return layout;
    }

}
