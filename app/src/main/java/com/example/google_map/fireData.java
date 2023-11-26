package com.example.google_map;

public class fireData {
    private  double latitude;
    private  double longitude;
    private double bright_ti4;
    private double scan;
    private double track;
    private static String acq_date;
    private int acq_time;
    private String satellite;
    private String instrument;
    private String confidence;
    private String version;
    private double bright_ti5;
    private double frp;
    private static String daynight;

    public  double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public  double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getBright_ti4() {
        return bright_ti4;
    }

    public void setBright_ti4(double bright_ti4) {
        this.bright_ti4 = bright_ti4;
    }

    public double getScan() {
        return scan;
    }

    public void setScan(double scan) {
        this.scan = scan;
    }

    public double getTrack() {
        return track;
    }

    public void setTrack(double track) {
        this.track = track;
    }

    public static String  getAcq_date() {
        return acq_date;
    }

    public void setAcq_date(String acq_date) {
        this.acq_date = acq_date;
    }

    public int getAcq_time() {
        return acq_time;
    }

    public void setAcq_time(int acq_time) {
        this.acq_time = acq_time;
    }

    public String getSatellite() {
        return satellite;
    }

    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getBright_ti5() {
        return bright_ti5;
    }

    public void setBright_ti5(double bright_ti5) {
        this.bright_ti5 = bright_ti5;
    }

    public double getFrp() {
        return frp;
    }

    public void setFrp(double frp) {
        this.frp = frp;
    }

    public static String getDaynight() {
        return daynight;
    }

    public void setDaynight(String daynight) {
        this.daynight = daynight;
    }
}
