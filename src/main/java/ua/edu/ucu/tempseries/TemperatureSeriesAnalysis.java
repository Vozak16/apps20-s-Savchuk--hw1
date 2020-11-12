package ua.edu.ucu.tempseries;


public class TemperatureSeriesAnalysis {
    double[] temperatureArray;
    int temperatureArraySize;
    static final int minTemperature = -273;
    public TemperatureSeriesAnalysis() {
        this.temperatureArray = new double[]{};
        this.temperatureArraySize = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {

        this.temperatureArray = temperatureSeries;
        this.temperatureArraySize = temperatureSeries.length;
    }

    public double average() throws IllegalArgumentException {
        this.CheckForEmptyArray();
        double sum = 0;
        for (int i = 0; i < this.temperatureArraySize; i++) {
            sum += temperatureArray[i];
        }
        return sum / temperatureArraySize;


    }

    public double deviation() {
        this.CheckForEmptyArray();
        double meanValue = 0;


        for (int i = 0; i < this.temperatureArraySize; i++) {
            meanValue += this.temperatureArray[i];
        }

        meanValue = meanValue / this.temperatureArraySize;
        double sumDifference = 0;
        for (int i = 0; i < this.temperatureArraySize; i++) {
            sumDifference += Math.pow(meanValue - this.temperatureArray[i], 2);
        }
        return Math.sqrt(sumDifference / this.temperatureArraySize);


    }


    public double Min() throws IllegalArgumentException {
        this.CheckForEmptyArray();
        double min = this.temperatureArray[0];
        for (int i = 0; i < this.temperatureArraySize; i++) {
            if (min > temperatureArray[i]) {
                min = temperatureArray[i];
            }
        }
        return min;

    }

    public double Max() throws IllegalArgumentException {
        this.CheckForEmptyArray();
        double max = this.temperatureArray[0];
        for (int i = 0; i < this.temperatureArraySize; i++) {
            if (max < temperatureArray[i]) {
                max = temperatureArray[i];
            }
        }
        return max;

    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public void CheckForEmptyArray() {
        if (this.temperatureArray.length == 0) {
            throw new IllegalArgumentException("The temperature series is empty!");
        }
    }

    public double findTempClosestToValue(double tempValue) {
        this.CheckForEmptyArray();
        double minDistance = Math.abs(this.temperatureArray[0] - tempValue);
        double TempClosestToValue = this.temperatureArray[0];
        for (int i = 0; i < this.temperatureArraySize; i++) {
            double Distance = Math.abs(this.temperatureArray[i] - tempValue);
            if (minDistance > Distance) {
                minDistance = Distance;
                TempClosestToValue = this.temperatureArray[i];

            }
        }
        return TempClosestToValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        CheckForEmptyArray();
        double[] newArray = new double[this.temperatureArray.length];
        int j = 0;
        for (int i = 0; i < this.temperatureArraySize; i++) {
            if(this.temperatureArray[i] < tempValue){
                newArray[j] = this.temperatureArray[i];
                j += 1;
            }
        }
        return newArray;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        CheckForEmptyArray();
        double[] newArray = new double[this.temperatureArray.length];
        int j = 0;
        for (int i = 0; i < this.temperatureArraySize; i++) {
            if(this.temperatureArray[i] > tempValue){
                newArray[j] = this.temperatureArray[i];
                j += 1;
            }
        }
        return newArray;
    }

    public TempSummaryStatistics summaryStatistics() throws IllegalArgumentException {

        CheckForEmptyArray();
        double avgTemp = this.average();
        double devTemp = this.deviation();
        double minTemp = this.Min();
        double maxTemp = this.Max();
        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public boolean CheckRightTemperature(double tempValue) {
        return tempValue > minTemperature;
    }

    public int addTemps(double... temps) {
        int newLength;
        if(this.temperatureArray.length != 0){
            newLength = this.temperatureArray.length;
        }
        else{
            newLength = temps.length;
        }

        while (this.temperatureArraySize + temps.length > newLength) {
            newLength = newLength * 2;
        }
        double[] newArray = new double[newLength];
        if (this.temperatureArraySize >= 0)
            System.arraycopy(this.temperatureArray, 0, newArray, 0, this.temperatureArraySize);
        int j = 0;
        for (double temp : temps) {

            if (CheckRightTemperature(temp)) {
                newArray[j + this.temperatureArraySize] = temp;
                j += 1;
            }

        }
        this.temperatureArray = newArray;
        this.temperatureArraySize = temps.length + this.temperatureArraySize;
        return this.temperatureArraySize;

    }
}