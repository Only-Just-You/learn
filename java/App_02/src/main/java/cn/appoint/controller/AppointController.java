package cn.appoint.controller;

import cn.appoint.dao.AppointBasicDAO;
import cn.appoint.domain.Appoint;
import cn.appoint.service.AppointBasicPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("appoint")
public class AppointController {
    @Autowired
    private AppointBasicPerform appointBasicPerform;
    @Autowired
    private AppointBasicDAO appointBasicDAO;
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    @ResponseBody
    public List<Appoint> findAllAppoint(){
        return appointBasicDAO.findAllAppoint();
    }
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Appoint findById(@PathVariable(value = "id") Integer id){
        return appointBasicDAO.findById(id);
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertAppoint(@RequestBody Appoint appoint){
        appointBasicDAO.insertAppointOneMessage(appoint);
    }
    @RequestMapping(value = "/insert/all", method = RequestMethod.POST)
    public void insertAllAppoint(@RequestBody List<Appoint> appoints_list){
        appointBasicPerform.insertAllAppoint(appoints_list);
    }
}
