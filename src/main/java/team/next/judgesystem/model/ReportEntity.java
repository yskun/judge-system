package team.next.judgesystem.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
@Entity
@Table(name = "Report", schema = "dbo", catalog = "shamomo")
public class ReportEntity {
    private int id;
    private String content;
    private String reason;
    private String reportIp;
    private Timestamp reportDate;
    private Timestamp reportTime;
    private String reportArea;
    private boolean outTime;
    private ManageStateEntity manageStateByManageStateId;
    private WebinfoEntity webinfoByReportUrl;
    private int manageStateId;
    private String reportUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "Reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "ReportIP")
    public String getReportIp() {
        return reportIp;
    }

    public void setReportIp(String reportIp) {
        this.reportIp = reportIp;
    }

    @Basic
    @Column(name = "ReportDate")
    public Timestamp getReportDate() {
        return reportDate;
    }

    public void setReportDate(Timestamp reportDate) {
        this.reportDate = reportDate;
    }

    @Basic
    @Column(name = "ReportTime")
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "ReportArea")
    public String getReportArea() {
        return reportArea;
    }

    public void setReportArea(String reportArea) {
        this.reportArea = reportArea;
    }

    @Basic
    @Column(name = "OutTime")
    public boolean isOutTime() {
        return outTime;
    }

    public void setOutTime(boolean outTime) {
        this.outTime = outTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportEntity that = (ReportEntity) o;

        if (id != that.id) return false;
        if (outTime != that.outTime) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (reportIp != null ? !reportIp.equals(that.reportIp) : that.reportIp != null) return false;
        if (reportDate != null ? !reportDate.equals(that.reportDate) : that.reportDate != null) return false;
        if (reportTime != null ? !reportTime.equals(that.reportTime) : that.reportTime != null) return false;
        if (reportArea != null ? !reportArea.equals(that.reportArea) : that.reportArea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (reportIp != null ? reportIp.hashCode() : 0);
        result = 31 * result + (reportDate != null ? reportDate.hashCode() : 0);
        result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
        result = 31 * result + (reportArea != null ? reportArea.hashCode() : 0);
        result = 31 * result + (outTime ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ManageStateId", referencedColumnName = "Id", nullable = false,insertable = false,updatable = false)
    public ManageStateEntity getManageStateByManageStateId() {
        return manageStateByManageStateId;
    }

    public void setManageStateByManageStateId(ManageStateEntity manageStateByManageStateId) {
        this.manageStateByManageStateId = manageStateByManageStateId;
    }

    @ManyToOne
    @JoinColumn(name = "ReportUrl", referencedColumnName = "Url",insertable = false,updatable = false)
    public WebinfoEntity getWebinfoByReportUrl() {
        return webinfoByReportUrl;
    }

    public void setWebinfoByReportUrl(WebinfoEntity webinfoByReportUrl) {
        this.webinfoByReportUrl = webinfoByReportUrl;
    }

    @Basic
    @Column(name = "ManageStateId")
    public int getManageStateId() {
        return manageStateId;
    }

    public void setManageStateId(int manageStateId) {
        this.manageStateId = manageStateId;
    }

    @Basic
    @Column(name = "ReportUrl")
    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

}
