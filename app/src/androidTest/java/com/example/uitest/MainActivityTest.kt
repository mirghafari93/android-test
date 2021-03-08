package com.example.uitest

import android.app.Instrumentation
import android.view.LayoutInflater
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Test


//@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest  {

//    @get:Rule
//    var activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

//    @get: Rule
//    val activityScenario = ActivityScenarioRule(MainActivity::class.java)


    @Test fun sample_test_1() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.mainPageLayout)).check(matches(isDisplayed()))
        activityScenario.onActivity {
            Screenshot.snapActivity(it).setName("MainActivity 111").record()
        }
    }

    @Test fun sample_test_2() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btnHomePage)).perform(click())
        onView(withId(R.id.homePageLayout)).check(matches(isDisplayed()))
        activityScenario.onActivity {
            Screenshot.snapActivity(it).setName("MainActivity 222").record()
        }
    }

    @Test
    @Throws(Throwable::class)
    fun testGoToHomePageAndReturnToMainPage() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btnHomePage)).perform(click())
        onView(withId(R.id.btnBack)).perform(click())
        onView(withId(R.id.mainPageLayout)).check(matches(isDisplayed()))

        activityScenario.onActivity {
            Screenshot.snapActivity(it).setName("MainActivity 333").record()
        }
    }

    @Test fun sample_test_4() {
        val instrumentation: Instrumentation = InstrumentationRegistry.getInstrumentation()
        val layoutInflater: LayoutInflater = LayoutInflater.from(instrumentation.targetContext)
        val view: View = layoutInflater.inflate(R.layout.activity_main, null, false)

        ViewHelpers.setupView(view).layout()
//        Screenshot.snap(view).setName("T 444").record()
    }



    @Test fun testJustOpenMainPage() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity {
            Screenshot.snapActivity(it).setName("MainActivity 555").record()
        }
    }

    @Test fun testMainPageLayout() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity {
            val view = LayoutInflater.from(it.applicationContext).inflate(R.layout.activity_home, null, false)
            ViewHelpers.setupView(view).layout()
//            Screenshot.snap(view).setName("MainActivity 666").record()
        }
    }
}