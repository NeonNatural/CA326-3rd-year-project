package ie.bim.myapplication.ui.twitter;

import android.app.Notification;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import ie.bim.myapplication.R;
import ie.bim.myapplication.data.ServiceGenerator;
import ie.bim.myapplication.data.TweetApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static android.content.Context.MODE_PRIVATE;

public class TwitterUpdatesFragment extends Fragment {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private TweetApi tweetApi;

    private SharedPreferences sharedPreferences;

    private TextToSpeech textToSpeech;

    private String oldTweet;

    private Timer timer;

    private boolean isPlaying;
    private EditText getUser;

    private Notification notification;

    private NotificationManagerCompat notificationManager;

    public TwitterUpdatesFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tweetApi = ServiceGenerator.createService(TweetApi.class);
        sharedPreferences = getActivity().getSharedPreferences("com.test", MODE_PRIVATE); // Hopefully never null

        textToSpeech = new TextToSpeech(getContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.UK);
            }
        });

        timer = new Timer();


        View layout = inflater.inflate(R.layout.fragment_twitter_updates, container, false);
        getUser = layout.findViewById(R.id.findTwitter);

        layout.findViewById(R.id.cyclingPlay).setOnClickListener(
                view -> {
                    if (!isPlaying) {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_exit_to_app_black_24dp));
                        play("BritishCycling");
                    } else {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp));
                        stop();
                    }
                }
        );

        layout.findViewById(R.id.soccerPlay).setOnClickListener(
                view -> {
                    if (!isPlaying) {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_exit_to_app_black_24dp));
                        play("@sistoney67");
                    } else {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp));
                        stop();
                    }
                }
        );

        layout.findViewById(R.id.f1Play).setOnClickListener(
                view -> {
                    if (!isPlaying) {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_exit_to_app_black_24dp));
                        play("SkySportsF1");
                    } else {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp));
                        stop();
                    }
                }
        );
        layout.findViewById(R.id.boxinPlay).setOnClickListener(
                view -> {
                    if (!isPlaying) {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_exit_to_app_black_24dp));
                        play("SkySportsBoxing");
                    } else {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp));
                        stop();
                    }
                }
        );
        layout.findViewById(R.id.basketballPlay).setOnClickListener(
                view -> {
                    if (!isPlaying) {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_exit_to_app_black_24dp));
                        play("NBATV");
                    } else {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp));
                        stop();
                    }
                }
        );
        layout.findViewById(R.id.audioupdaterPlay).setOnClickListener(
                view -> {
                    if (!isPlaying) {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_exit_to_app_black_24dp));
                        play("AudioUpdater");
                    } else {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp));
                        stop();
                    }
                }
        );
        layout.findViewById(R.id.followUser).setOnClickListener(
                view -> {
                    if (!isPlaying) {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_exit_to_app_black_24dp));
                        play(getUser.getText().toString());
                    } else {
                        ((MaterialButton) view).setIcon(getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp));
                        stop();
                    }
                }
        );

        return layout;
    }

    @Override
    public void onPause() {


        timer.cancel();
        compositeDisposable.clear();
        super.onPause();
    }

    private void navigate(@IdRes int fragmentId) {
        if (getActivity() != null) {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(fragmentId);
        }
    }

    private void play(String username) {
        isPlaying = true;

        timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getTweet(username);
            }
        }, 0, 5000);
    }

    private void stop() {
        oldTweet = "";
        textToSpeech.stop();
        timer.cancel();

        isPlaying = false;
    }

    private void getTweet(String username) {
        compositeDisposable.add(tweetApi.getTweet(sharedPreferences.getString("bearer", ""), username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (tweet) -> {
                            String text = tweet.get(0).text;
                            if (!text.equals(oldTweet)) {
                                showNotification(text);
                                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                                oldTweet = text;
                            }
                        },
                        (error) -> {
                            if (error instanceof HttpException) {
                                if (((HttpException) error).code() == 404) {
                                    Toast.makeText(getContext(), getString(R.string.network_error_user_missing), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Unauthorized request!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                )
        );
    }

    private void showNotification(String tweet) {
        notification = new NotificationCompat.Builder(getActivity().getApplicationContext(), "500")
                .setSmallIcon(R.drawable.ic_menu_send)
                .setContentTitle("Update")
                .setContentText(tweet)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setStyle(new NotificationCompat.BigTextStyle()).build();
        notificationManager = NotificationManagerCompat.from(getActivity().getApplicationContext());
        notificationManager.notify(500, notification);
    }


}
