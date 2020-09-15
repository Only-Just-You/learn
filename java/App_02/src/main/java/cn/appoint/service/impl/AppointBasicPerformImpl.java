package cn.appoint.service.impl;

import cn.appoint.dao.AppointBasicDAO;
import cn.appoint.domain.Appoint;
import cn.appoint.service.AppointBasicPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointBasicPerformImpl implements AppointBasicPerform {
    @Autowired
    private AppointBasicDAO appointBasicDAO;
    @Override
    public void insertAllAppoint(List<Appoint> appoints_list) {
        for (Appoint appoint:appoints_list){
            appointBasicDAO.insertAppointOneMessage(appoint);
        }
    }
}
