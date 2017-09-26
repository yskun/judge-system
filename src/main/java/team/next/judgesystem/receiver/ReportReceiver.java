package team.next.judgesystem.receiver;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
public class ReportReceiver {
    private String Url;
    private String IpAddress;
    private String Region;
    private String ReportReson;
    private String ReportDetail;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getReportReson() {
        return ReportReson;
    }

    public void setReportReson(String reportReson) {
        ReportReson = reportReson;
    }

    public String getReportDetail() {
        return ReportDetail;
    }

    public void setReportDetail(String reportDetail) {
        ReportDetail = reportDetail;
    }
}
