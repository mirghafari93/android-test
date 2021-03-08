package com.example.uitest

import androidx.test.core.app.ActivityScenario
import com.facebook.testing.screenshot.Screenshot
import org.junit.Test


//@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

//    @get: Rule
//    val activityScenario = ActivityScenarioRule(HomeActivity::class.java)


//    @Test
//    fun sample_test_1() {
//        //        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        Espresso.onView(ViewMatchers.withId(R.id.homePageLayout))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    }


//    @Test fun sample_test_2() {
//        Espresso.onView(ViewMatchers.withId(R.id.btnBack)).perform(ViewActions.click())
////        Espresso.onView(ViewMatchers.withId(R.id.mainPageLayout))
////            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    }

    @Test fun sample_test_3() {
        val activityScenario = ActivityScenario.launch(HomeActivity::class.java)
        activityScenario.onActivity {
            Screenshot.snapActivity(it).setName("HomeActivity 111").record()
        }
    }
}
