package np.com.manishtuladhar.ordertea;


import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingResource;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

public class IdlingResourceMenuActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource(){
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        //register the test
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void idlingResourceTest()
    {
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(0).perform(click());
    }

    // unregister resources
    @After
    public void unregisterIdlingResource(){
        if(mIdlingResource!=null)
        {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }
}
