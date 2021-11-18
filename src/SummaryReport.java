/*
Group Member: Will Jefferson
Class: SummaryReport.java
Description: Holds attributes for Summary Report
*/

public class SummaryReport {

    // private variables to hold summary report data
    private String summaryReportProviderList;
    private int summaryReportConsultationsNum;
    private double summaryReportTotalFee;
    private int summaryReportProviderTotal;
    private int summaryReportTotalConsultations;
    private double summaryReportOverallFee;

    // initialize the variables to null
    public void summaryReport() {
        summaryReportProviderList = null;
        summaryReportConsultationsNum = 0;
        summaryReportTotalFee = 0;
        summaryReportProviderTotal = 0;
        summaryReportTotalConsultations = 0;
        summaryReportOverallFee = 0;
    }

}