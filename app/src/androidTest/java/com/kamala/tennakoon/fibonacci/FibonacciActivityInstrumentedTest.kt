package com.kamala.tennakoon.fibonacci

import android.content.pm.ActivityInfo
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.ActivityAction
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.kamala.tennakoon.fibonacci.view.FibonacciActivity
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FibonacciActivityInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.kamala.tennakoon.fibonacci", appContext.packageName)
    }

    @Test
    fun fibonacciActivity() {
        val activityScenario =  ActivityScenario.launch(FibonacciActivity::class.java)

        ActivityScenario.launch(FibonacciActivity::class.java).use { scenario ->

            scenario.onActivity(ActivityAction<FibonacciActivity> { activity: FibonacciActivity ->
                Assert.assertNotNull("TextView should exist", activity.findViewById<TextView>(R.id.fibonacciTextView))
                Assert.assertNotNull("Button should exist", activity.findViewById<TextView>(R.id.nextFibonacciButton))
                Assert.assertEquals("initial state of fibonacci as 0", "0", activity.findViewById<TextView>(R.id.fibonacciTextView).text)
                Assert.assertEquals("initiial state of calculation should not show", "", activity.findViewById<TextView>(R.id.fibonacciCalculationTextView).text)

                activity.findViewById<TextView>(R.id.nextFibonacciButton).performClick()
                Assert.assertEquals("first fibonacci should update result to textview", "1", activity.findViewById<TextView>(R.id.fibonacciTextView).text)
                Assert.assertEquals("first fibonacci should not show calculation to textview", "", activity.findViewById<TextView>(R.id.fibonacciCalculationTextView).text)

                activity.findViewById<TextView>(R.id.nextFibonacciButton).performClick()
                Assert.assertEquals("second fibonacci should update result to textview", "1", activity.findViewById<TextView>(R.id.fibonacciTextView).text)
                Assert.assertEquals("second fibonacci should update calculation to textview", "0 + 1", activity.findViewById<TextView>(R.id.fibonacciCalculationTextView).text)

                val newOrientation = if(activity.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE else ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                activity.setRequestedOrientation(newOrientation)
                Assert.assertEquals("orientation changes should not reset result data", "1", activity.findViewById<TextView>(R.id.fibonacciTextView).text)
                Assert.assertEquals("orientation changes should not reset calculation data", "0 + 1", activity.findViewById<TextView>(R.id.fibonacciCalculationTextView).text)

                activity.findViewById<TextView>(R.id.nextFibonacciButton).performClick()
                Assert.assertEquals("third fibonacci should update result to textview", "2", activity.findViewById<TextView>(R.id.fibonacciTextView).text)
                Assert.assertEquals("third fibonacci calculation should update calculation to textview", "1 + 1", activity.findViewById<TextView>(R.id.fibonacciCalculationTextView).text)
            })

        }
    }
}