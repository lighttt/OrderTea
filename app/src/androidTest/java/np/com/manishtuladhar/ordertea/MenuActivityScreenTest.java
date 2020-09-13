package np.com.manishtuladhar.ordertea;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    // activity test for menu activity
    @Rule
    public ActivityScenarioRule<MenuActivity> mActivityTestRule = new ActivityScenarioRule<>(MenuActivity.class);

    //const for matching
    public static final String TEA_NAME = "Green Tea";

    // click on the grid view testing
    @Test
    public void clickGridViewItem_OpenOrdersActivity(){

        //reference to a specific grid view item and click it
        // data can be anything
        // adapter view position click
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());

        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));
    }
}
