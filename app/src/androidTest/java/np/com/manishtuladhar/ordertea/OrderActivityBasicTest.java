package np.com.manishtuladhar.ordertea;

import android.app.Activity;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

// RunWith AndroidJunit4: Default test runner
@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    // functional testing for single activity testing
    // when activity is launched each test is annotated with @Test
    @Rule
    public ActivityScenarioRule<OrderActivity> mActivityTestRule = new ActivityScenarioRule<>(OrderActivity.class);


    //test for checking increment and decrement on cost
    @Test
    public void clickDecrementBtn_ChangeQuantityAndCost()
    {
        //check initial value is 0
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));

        //click the decrement button
        onView(withId(R.id.decrement_button)).perform(click());

        //verify if the quantity changes from 1 to 0
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));

        //verify if the cost changes 5 to 0
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));
    }

}
