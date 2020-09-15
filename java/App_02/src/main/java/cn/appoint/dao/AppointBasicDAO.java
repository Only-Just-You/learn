package cn.appoint.dao;

import cn.appoint.domain.Appoint;

import java.util.List;

public interface AppointBasicDAO {
    List<Appoint> findAllAppoint();
    Appoint findById(Integer id);
    void insertAppointOneMessage(Appoint appoint);
}
