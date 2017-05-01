package com.cloudhuan.spoontest;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.FlakyTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.TextView;

import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by cloudhuan on 2017/5/1.
 */
@RunWith(AndroidJUnit4.class)
public class SpoonTest {

    Solo solo;

    @Before
    public void setUp(){
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),activityTestRule.getActivity());
    }

    @After
    public void ternDown(){
        solo.finishOpenedActivities();
    }

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    @FlakyTest(bugId = 2)
    public void testPass(){
        Log.d("cloudhuan","begin test");
        Assert.assertThat(getText(), CoreMatchers.equalTo("Hello World!"));
        solo.clickOnView(solo.getView(R.id.btn));
        Assert.assertThat(getText(), CoreMatchers.equalTo("test00"));
        solo.clickOnView(solo.getView(R.id.btn));
        Assert.assertThat(getText(), CoreMatchers.equalTo("test01"));
        solo.clickOnView(solo.getView(R.id.btn));
        Assert.assertThat(getText(), CoreMatchers.equalTo("test02"));
        Log.d("cloudhuan","end test");

    }

    @Test
    @FlakyTest(bugId = 2)
    public void testFail(){
        Log.d("cloudhuan","failcase begin");
        try {
            solo.clickOnView(solo.getView(R.id.basic));
        }catch (Exception e){
            Log.d("cloudhuan","exception!");

        }
        Log.d("cloudhuan","failcase end");
    }

    private String getText(){
        TextView tv = (TextView)solo.getView(R.id.tv);
        return tv.getText().toString();
    }
}
