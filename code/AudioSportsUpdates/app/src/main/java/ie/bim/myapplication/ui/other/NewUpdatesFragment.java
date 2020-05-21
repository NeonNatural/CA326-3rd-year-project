package ie.bim.myapplication.ui.other;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import ie.bim.myapplication.R;
import ie.bim.myapplication.ui.welcome.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

public class NewUpdatesFragment extends Fragment {

    private String filePath;
    private SharedPreferences sharedPreferences;
    private MediaPlayer mediaPlayer;
    private MediaRecorder mrecorder;
    private StorageReference mStorageRef;
    public boolean done = true;
    public String email;
    private String followName;
    private EditText getUserName;
    private static final int MY_PERMISSIONS_REQUEST =1;
    FirebaseUser currentUser;
    FirebaseAuth mAuth;
    private String name;



    public NewUpdatesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_new_updates, container, false);
        sharedPreferences = getActivity().getSharedPreferences("com.test", MODE_PRIVATE); // Hopefully never null
        mStorageRef = FirebaseStorage.getInstance().getReference();
        filePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        filePath += "/UserMessage.3gp";
        micPermissions();
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        name = currentUser.getDisplayName();



        getUserName = layout.findViewById(R.id.userName);
        layout.findViewById(R.id.recordBtn).setOnClickListener(
                view -> {
                    if(ContextCompat.checkSelfPermission(this.getContext(),Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this.getContext(),"Please enable microphone in app settings.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (done == true) {
                        done = false;
                        mrecorder = new MediaRecorder();
                        mrecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mrecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mrecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        mrecorder.setOutputFile(filePath);
                        try {
                            mrecorder.prepare();
                            mrecorder.start();
                            Toast.makeText(this.getContext(), "Recording", Toast.LENGTH_LONG).show();

                        } catch (IOException ex) {
                        }

                    } else {
                        Toast.makeText(this.getContext(), "Already Recording", Toast.LENGTH_LONG).show();
                    }
                }
        );
        layout.findViewById(R.id.stopBtn).setOnClickListener(
                view -> {
                    Toast.makeText(this.getContext(),"Recording finished",Toast.LENGTH_SHORT).show();
                    done = true;
                    try {
                        mrecorder.reset();
                        mrecorder.prepare();
                        mrecorder.stop();
                        mrecorder.release();
                        mrecorder = null;

                    } catch (Exception e) {
                    }
                }
        );

        layout.findViewById(R.id.uploadBtn).setOnClickListener(
                view -> {
                    try {
                        Toast.makeText(this.getContext(),"Uploading",Toast.LENGTH_SHORT).show();
                        uploadAudio();
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "No ", Toast.LENGTH_SHORT).show();

                    }
                }
        );
        layout.findViewById(R.id.getMsgBtn).setOnClickListener(
                view -> {
                    downloadAudio();
                }
        );



        return layout;
    }

    private void uploadAudio() {
        StorageReference filepath = mStorageRef.child(name);
        Uri uri = Uri.fromFile(new File(filePath));
        filepath.putFile(uri);
    }

    private void downloadAudio() {
        mediaPlayer = new MediaPlayer();
        if(!getUserName.getText().toString().isEmpty()){
            followName = getUserName.getText().toString();
            StorageReference downFile = mStorageRef.child(followName);
            downFile.getDownloadUrl().addOnSuccessListener(uri -> {
                final String url = uri.toString();
                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (Exception e) {
                    Toast.makeText(getContext(), getString(R.string.network_error_user_missing), Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(e ->
                    Toast.makeText(getContext(), getString(R.string.network_error_user_missing), Toast.LENGTH_SHORT).show()
            );

        }
        else{
            Toast.makeText(getContext(),"Please enter a UserName",Toast.LENGTH_SHORT).show();
        }


    }
    public void micPermissions(){
        if(ContextCompat.checkSelfPermission(this.getContext(),Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this.getActivity(),new String[]{Manifest.permission.RECORD_AUDIO},
                    MY_PERMISSIONS_REQUEST);


        }
    }
    public void storagePermissions(){
        if(ContextCompat.checkSelfPermission(this.getContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this.getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST);


        }
    }


}

