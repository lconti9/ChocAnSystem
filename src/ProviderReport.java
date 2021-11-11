/*
Group Member: Shanissee Lee
Class: ProviderReport.java
Description: Holds attributes for Provider Report
*/

public class ProviderReport {

    //private variables to hold provider report data
    private String providerReportDate;
    private String providerReportDateComp;
    private String providerReportMemberName;
    private int providerReportMemberNumber;
    private int providerReportServiceCode;
    private double providerReportServiceFee;
    private int providerReportConsultationsNum;
    private double providerReportTotalFee;

    //initialize the variables to null
    public providerReport(){
        providerReportDate = null;
        providerReportDateComp = null;
        providerReportMemberName = null;
        providerReportMemberNumber = 0;
        providerReportServiceCode = 0;
        providerReportServiceFee = 0;
        providerReportConsultationsNum = 0;
        providerReportTotalFee = 0;
    }
    
}