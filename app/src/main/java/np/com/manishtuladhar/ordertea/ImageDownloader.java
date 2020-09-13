package np.com.manishtuladhar.ordertea;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import np.com.manishtuladhar.ordertea.idlingresource.SimpleIdlingResource;
import np.com.manishtuladhar.ordertea.model.Tea;

public class ImageDownloader {

    private static final int DELAY_MILLIS = 3000;

    // Create an ArrayList of mTeas
    final static ArrayList<Tea> mTeas = new ArrayList<>();

    interface DelayerCallback {
        void onDone(ArrayList<Tea> teas);
    }

    static void downloadImage(Context context, final DelayerCallback callback,
                              @Nullable final SimpleIdlingResource idlingResource) {
        /** For checking sure if idling resource is null or not
         * If the idling resource is null:
         * idle state is true, espresso can perform the next action
         * idle state is false, espresso will wait until it is true again
         */
        if (idlingResource != null) {
            idlingResource.setIdleState(false);
        }

        //Display a toast for images are downloading
        String text = context.getString(R.string.loading_msg);
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();

        //fill in the tea objects
        mTeas.add(new Tea(context.getString(R.string.black_tea_name), R.drawable.black_tea));
        mTeas.add(new Tea(context.getString(R.string.green_tea_name), R.drawable.green_tea));
        mTeas.add(new Tea(context.getString(R.string.white_tea_name), R.drawable.white_tea));
        mTeas.add(new Tea(context.getString(R.string.oolong_tea_name), R.drawable.oolong_tea));
        mTeas.add(new Tea(context.getString(R.string.honey_lemon_tea_name), R.drawable.honey_lemon_tea));
        mTeas.add(new Tea(context.getString(R.string.chamomile_tea_name), R.drawable.chamomile_tea));

        // added a delay for simulating download
        android.os.Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onDone(mTeas);
                    if (idlingResource != null) {
                        idlingResource.setIdleState(true);
                    }
                }
            }
        }, DELAY_MILLIS);
    }

}
