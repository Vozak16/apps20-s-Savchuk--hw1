package ua.edu.ucu.tempseries;


public class TemperatureSeriesAnalysis {
    static final int MinTemperature = -273;
    double[] temperatureArray;
    int temperatureArraySize;
    public TemperatureSeriesAnalysis() {
        this.temperatureArray = new double[]{};
        this.temperatureArraySize = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {

        this.temperatureArray = temperatureSeries;
        this.temperatureArraySize = temperatureSeries.length;
    }

    public double average() throws IllegalArgumentException {
        this.checkForEmptyArray();
        double sum = 0;
        for (int i = 0; i < this.temperatureArraySize; i++) {
            sum += temperatureArray[i];
        }
        return sum / temperatureArraySize;


    }

    public double deviation() {
        this.checkForEmptyArray();
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
        this.checkForEmptyArray();
        double min = this.temperatureArray[0];
        for (int i = 0; i < this.temperatureArraySize; i++) {
            if (min > temperatureArray[i]) {
                min = temperatureArray[i];
            }
        }
        return min;

    }

    public double Max() throws IllegalArgumentException {
        this.checkForEmptyArray();
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

    public void checkForEmptyArray() {
        if (this.temperatureArray.length == 0) {
            throw new IllegalArgumentException("The temperature " +
                    "series is empty!");
        }
    }

    public double findTempClosestToValue(double tempValue) {
        this.checkForEmptyArray();
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
        checkForEmptyArray();
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
        checkForEmptyArray();
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

        checkForEmptyArray();
        double avgTemp = this.average();
        double devTemp = this.deviation();
        double minTemp = this.Min();
        double maxTemp = this.Max();
        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public boolean checkRightTemperature(double tempValue) {
        return tempValue > MinTemperature;
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

            if (checkRightTemperature(temp)) {
                newArray[j + this.temperatureArraySize] = temp;
                j += 1;
            }

        }
        this.temperatureArray = newArray;
        this.temperatureArraySize = temps.length + this.temperatureArraySize;
        return this.temperatureArraySize;

    }
}