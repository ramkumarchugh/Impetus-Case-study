package com.insurance.app.service;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.ApplicationPolicyDao;
import com.insurance.app.model.ApplicationPolicy;

/** The Class AutoApprovalServiceImpl. */
@Service
public class AutoApprovalServiceImpl implements AutoApprovalService {

    /** The dao. */
    @Autowired
    ApplicationPolicyDao dao;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(AutoApprovalServiceImpl.class);

    /** Auto approved.
     *
     * @return the application policy */
    @Override

    @Scheduled(cron = "0 */4 * ? * *")
    public ApplicationPolicy autoApproved() {

        List<ApplicationPolicy> applicationPolicyLst = (List<ApplicationPolicy>) dao.findAll();
        LOGGER.info("schedular is invoked");
        for (int i = 0; i < applicationPolicyLst.size(); i++) {
            if (applicationPolicyLst.get(i).getStatus().equals("Application Submitted")) {
                LOGGER.info("schedular is invoked");

                int revisedSal = (applicationPolicyLst.get(i).getSalary() * 10) / 100;
                if (applicationPolicyLst.get(i).getPremium() > revisedSal || applicationPolicyLst.get(i).getAge() > 90) {

                    applicationPolicyLst.get(i).setStatus("Under Review");
                    dao.save(applicationPolicyLst.get(i));

                    LOGGER.info(applicationPolicyLst.get(i));

                }

                else {

                    applicationPolicyLst.get(i).setStatus("Auto approved");

                    LOGGER.info(applicationPolicyLst.get(i));

                    dao.save(applicationPolicyLst.get(i));

                }

            }
        }
        return null;

    }
}
