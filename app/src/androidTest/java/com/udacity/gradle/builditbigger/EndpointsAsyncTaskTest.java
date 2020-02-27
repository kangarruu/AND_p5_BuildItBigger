package com.udacity.gradle.builditbigger;

import android.content.Context;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import 	androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4ClassRunner.class)
public class EndpointsAsyncTaskTest {

    Context context;

    @Test
    public void  test_AsyncTask_ResultStringNotNull() throws InterruptedException {
        assertTrue(true);
        //create CountDownLatch to tell testing framework to wait till AsyncTask is finished
        final CountDownLatch signal = new CountDownLatch(1);
        context = ApplicationProvider.getApplicationContext();

        EndpointsAsyncTask mAsyncTask = new EndpointsAsyncTask(){
        @Override
        protected void onPostExecute(String joke) {
            //assert that the String is neither null nor empty
            assertNotNull(joke);
            if (joke != null) {
                assertTrue(joke.length() > 0);
                signal.countDown();
            }
        }
    };
        mAsyncTask.execute(context);
        signal.await();
    }

}