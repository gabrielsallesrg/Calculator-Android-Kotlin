package br.com.rg.gabrielsalles.calculator.Helper

import org.junit.Assert.assertEquals
import org.junit.Test

class HelperMethodsTest {
    @Test
    fun additionIsCorrect() {
        assertEquals(4.2, HelperMethods.add(1.5, 2.7), 0.0001)
    }
    @Test
    fun subtractionIsCorrect() {
        assertEquals(-1.2, HelperMethods.sub(1.5, 2.7), 0.0001)
    }
    @Test
    fun multiplicationIsCorrect() {
        assertEquals(4.05, HelperMethods.mult(1.5, 2.7), 0.0001)
    }
    @Test
    fun divisionIsCorrect() {
        assertEquals(0.5555, HelperMethods.div(1.5, 2.7), 0.001)
    }

    @Test
    fun dividingByZero() {
        assertEquals(Double.POSITIVE_INFINITY, HelperMethods.div(1.5, 0.0), 0.001)
    }
}