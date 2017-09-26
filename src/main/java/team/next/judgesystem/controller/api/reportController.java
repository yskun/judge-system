package team.next.judgesystem.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.next.judgesystem.model.ReportEntity;
import team.next.judgesystem.receiver.ReportReceiver;
import team.next.judgesystem.repo.ReportRepository;
import team.next.judgesystem.respondModel.StateRespondModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */

@RestController
public class reportController {
    @Autowired
    public reportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    private final ReportRepository reportRepository;

    @RequestMapping(value = "/api/report", method = RequestMethod.POST)
    public StateRespondModel report(ReportReceiver report) {
        List<ReportEntity> reportEntities = reportRepository
                .findAllByReportUrlAndReportIp(report.getUrl(), report.getIpAddress());
        for (ReportEntity r :
                reportEntities) {
            if (r.getReportDate().getTime() - Timestamp.valueOf(LocalDateTime.now()).getTime() < 600000) {
                StateRespondModel state = new StateRespondModel();
                state.setState(1);
                return state;
            }
        }


        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setContent(report.getReportDetail());
        reportEntity.setReason(report.getReportReson());
        reportEntity.setReportIp(report.getIpAddress());
        reportEntity.setReportTime(Timestamp.valueOf(LocalDateTime.now()));
        reportEntity.setReportArea(report.getRegion());
        reportEntity.setOutTime(false);
        reportEntity.setManageStateId(1);
        reportEntity.setReportUrl(report.getUrl());
        reportEntity.setReportDate(Timestamp.valueOf(LocalDateTime.now()));
        reportRepository.save(reportEntity);
        StateRespondModel state = new StateRespondModel();
        state.setState(0);
        return state;
    }
}
