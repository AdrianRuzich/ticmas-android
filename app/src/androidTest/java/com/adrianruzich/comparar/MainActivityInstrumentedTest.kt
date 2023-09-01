package com.adrianruzich.comparar

import com.adrianruzich.comparar.view.MainActivity
import org.junit.Test
import org.junit.Assert.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Before
import org.junit.After
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
    }
    @After
    fun teardown() {
    }

    @Test fun mainActivity_CompararCadenasIniciales() {
        Espresso.onView(ViewMatchers.withId(R.id.boton)).perform(
            ViewActions.click(),
        )

        Espresso.onView(ViewMatchers.withId(R.id.resultado)).check(
            ViewAssertions.matches(ViewMatchers.withText(R.string.textosIguales))
        )
    }

    @Test fun mainActivity_CompararCadenasIguales() {
        Espresso.onView(ViewMatchers.withId(R.id.entrada1)).perform(
            ViewActions.typeText("Prueba"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(ViewMatchers.withId(R.id.entrada2)).perform(
            ViewActions.typeText("Prueba"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(ViewMatchers.withId(R.id.boton)).perform(
            ViewActions.click(),
        )

        Espresso.onView(ViewMatchers.withId(R.id.resultado)).check(
            ViewAssertions.matches(ViewMatchers.withText(R.string.textosIguales))
        )
    }

    @Test fun mainActivity_CompararCadenasDistintas() {
        Espresso.onView(ViewMatchers.withId(R.id.entrada1)).perform(
            ViewActions.typeText("prueba"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(ViewMatchers.withId(R.id.entrada2)).perform(
            ViewActions.typeText("Prueba"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(ViewMatchers.withId(R.id.boton)).perform(
            ViewActions.click(),
        )

        Espresso.onView(ViewMatchers.withId(R.id.resultado)).check(
            ViewAssertions.matches(ViewMatchers.withText(R.string.textosDistintos))
        )
    }
}
