package np.com.manishtuladhar.ordertea;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class OrderSummaryActivityTest {

    //message to be send
    private static  final String emailMessage ="I just ordered a delicious tea from Samip Chiya Ghar. Next time you are craving a tea, check them out!";

    @Rule
    public IntentsTestRule<OrderSummaryActivity> mActivityRule =
            new IntentsTestRule<>(OrderSummaryActivity.class);


    // stub : kinda a mockup that helps to check external intents are allowed or blocked
    @Before
    public void stubAllExternalIntent()
    {
        intending(not(isInternal()))
                .respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void clickSendEmailButton_SendsEmail()
    {
        //click the send email button
        onView(withId(R.id.send_email_button)).perform(click());

        //check if the intent matches
        intended(allOf(
                hasAction(Intent.ACTION_SENDTO),
                hasExtra(Intent.EXTRA_TEXT,emailMessage)
        ));
    }

}
