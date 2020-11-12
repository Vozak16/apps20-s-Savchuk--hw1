package ua.edu.ucu.tempseries;

import jdk.nashorn.internal.objects.annotations.Getter;

final public class TempSummaryStatistics {
    final private double avgTemp;
    final private double devTemp;
    final private double minTemp;
    final private double maxTemp;

    public TempSummaryStatistics(double avgTemp, double devTemp,
                                 double minTemp, double maxTemp){
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    @Getter
    public double getAvgTemp(){
        return this.avgTemp;
    }

    @Getter
    public double getDevTemp(){
        return this.devTemp;
    }

    @Getter
    public double getMaxTemp(){
        return this.maxTemp;
    }

    @Getter
    public double getMinTemp(){
        return this.minTemp;
    }
}
