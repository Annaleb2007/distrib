package com.example.distrib

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Random
import kotlin.math.exp
import kotlin.math.sqrt

class ExampleUnitTest {

    @Test
    fun getLogNormalRandomValue_withPositiveMeanAndVariance_returnsPositiveValue() {
        val mean = 1.0
        val variance = 0.5
        val result = getLogNormalRandomValue(mean, variance)

        assertTrue(result > 0.0)
    }

    @Test
    fun getLogNormalRandomValue_withNegativeMeanAndVariance_returnsPositiveValue() {
        val mean = -1.0
        val variance = 0.5
        val result = getLogNormalRandomValue(mean, variance)

        assertTrue(result > 0.0)
    }

    @Test
    fun getLogNormalRandomValue_withZeroMeanAndVariance_returnsPositiveValue() {
        val mean = 0.0
        val variance = 0.0
        val result = getLogNormalRandomValue(mean, variance)

        assertEquals(1.0, result, 0.001)
    }

    @Test
    fun getLogNormalRandomValue_withExtremeMeanAndVariance_returnsValidValue() {
        val mean = 100.0
        val variance = 1000.0
        val result = getLogNormalRandomValue(mean, variance)

        assertTrue(result > 0.0)
    }

    private fun getLogNormalRandomValue(mean: Double, variance: Double): Double {
        val standardNormalRandomValue = Random().nextGaussian()
        return exp(mean + variance / 2.0) * exp(standardNormalRandomValue * sqrt(variance))
    }
}
