package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() throws IllegalAccessException {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }


    @Test
    public void testAverage() throws IllegalAccessException {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviation() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.445222154178573;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        double actualResult = seriesAnalysis.deviation();

    }

    @Test
    public void testDeviationWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {-7.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        // call tested method
        double actualResult = seriesAnalysis.Min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -7.0;

        // call tested method
        double actualResult = seriesAnalysis.Min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double actualResult = seriesAnalysis.Min();
    }
    @Test
    public void testMaxWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        // call tested method
        double actualResult = seriesAnalysis.Max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMax() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 6.0;

        // call tested method
        double actualResult = seriesAnalysis.Max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double actualResult = seriesAnalysis.Max();
    }

    @Test
    public void testfindTempClosestToZeroWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToZero() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testfindTempClosestToZeroWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double actualResult = seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testfindTempClosestToValueWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(0.0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToValue() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(4.9);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testfindTempClosestToValueWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double actualResult = seriesAnalysis.findTempClosestToValue(5.0);
    }

    @Test
    public void testfindTempsLessThenWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {0.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(0.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThen() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.0,4.0,-7.0,2.0,0.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(4.9);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testfindTempsLessThenWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double[] actualResult = seriesAnalysis.findTempsLessThen(5.0);
    }

    @Test
    public void testfindTempsGreaterThenWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {2.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(0.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThen() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {6.0,0.0,0.0,0.0,0.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(4.9);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testfindTempsGreaterThenWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(5.0);
    }

    @Test
    public void testsummaryStatisticsWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        double expectedAvgTemp = 2.0;
        double expectedDevTemp = 0.0;
        double expectedMaxTemp = 2.0;
        double expectedMinTemp = 2.0;

        assertEquals(actualResult.getAvgTemp(), expectedAvgTemp, 0.00001);
        assertEquals(actualResult.getDevTemp(), expectedDevTemp, 0.00001);
        assertEquals(actualResult.getMaxTemp(), expectedMaxTemp, 0.00001);
        assertEquals(actualResult.getMinTemp(), expectedMinTemp, 0.00001);

        // compare expected result with actual result
        assertTrue(actualResult != null);
    }

    @Test
    public void testsummaryStatistics() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        double expectedAvgTemp = 1.2;
        double expectedDevTemp = 4.445222154178573;
        double expectedMaxTemp = 6.0;
        double expectedMinTemp = -7.0;

        assertEquals(actualResult.getAvgTemp(), expectedAvgTemp, 0.00001);
        assertEquals(actualResult.getDevTemp(), expectedDevTemp, 0.00001);
        assertEquals(actualResult.getMaxTemp(), expectedMaxTemp, 0.00001);
        assertEquals(actualResult.getMinTemp(), expectedMinTemp, 0.00001);

        // compare expected result with actual result
        assertTrue(actualResult != null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testsummaryStatisticsWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testaddTempsWithOneElementArray() throws IllegalAccessException {
        // setup input data and expected result
        double[] temperatureSeries = {2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 4;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(1.0, 12.0, 13.0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testaddTemps() throws IllegalArgumentException {
        // setup input data and expected result
        double[] temperatureSeries = {1.0,4.0,-7.0,2.0,6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 8;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(1.0, 12.0, 13.0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testaddTempsWithEmptyArray() throws IllegalArgumentException {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        int expResult = 3;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(1.0, 12.0, 13.0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult);
    }










}
