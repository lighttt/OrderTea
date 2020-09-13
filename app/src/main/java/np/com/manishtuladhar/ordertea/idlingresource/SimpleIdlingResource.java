package np.com.manishtuladhar.ordertea.idlingresource;

import androidx.annotation.Nullable;
import androidx.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleIdlingResource implements IdlingResource {

    // helps to record visibility
    // runs in separate thread
    // for helping with callback if idle is true or false
    @Nullable private volatile ResourceCallback mCallback;

    // idleness is controlled by this boolean
    private AtomicBoolean mIsIdleNow = new AtomicBoolean(true);

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }

    /**
     * Sets the new idle state, if idle now is true and resource callback is not null
     * @param isIdleNow false if there any operations on going else true
     */
    public void setIdleState(boolean isIdleNow)
    {
        mIsIdleNow.set(isIdleNow);
        if(isIdleNow && mCallback !=null)
        {
            mCallback.onTransitionToIdle();
        }
    }
}
