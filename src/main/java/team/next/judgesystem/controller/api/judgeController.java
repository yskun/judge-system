package team.next.judgesystem.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.next.judgesystem.model.WebinfoEntity;
import team.next.judgesystem.receiver.JudgeReceiver;
import team.next.judgesystem.repo.WebinfoRepository;
import team.next.judgesystem.respondModel.RepoRespondModel;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
@RestController
public class judgeController {
    private final
    WebinfoRepository webinfoRepository;

    @Autowired
    public judgeController(WebinfoRepository webinfoRepository) {
        this.webinfoRepository = webinfoRepository;
    }



    @RequestMapping(value = "/api/judge", method = RequestMethod.POST)
    public RepoRespondModel judge(JudgeReceiver judgeReceiver) {
        WebinfoEntity webinfoEntity = webinfoRepository.findByUrl(judgeReceiver.getUrl());

        if (webinfoEntity == null) {
            WebinfoEntity newWebinfoEntity = new WebinfoEntity();
            newWebinfoEntity.setUrl(judgeReceiver.getUrl());
            newWebinfoEntity.setWebstate(1);

            webinfoRepository.save(newWebinfoEntity);
            RepoRespondModel repo = new RepoRespondModel();
            repo.setRet(1);
            return repo;
        } else {
            RepoRespondModel repo = new RepoRespondModel();
            repo.setRet(webinfoEntity.getWebstate());
            return repo;
        }
    }
}
