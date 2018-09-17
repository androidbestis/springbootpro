package com.adonai.controller;

import com.adonai.entity.Visitor;
import com.adonai.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 核心代码很简单，每过来一个请求，判断是否已经统计过，如果没有统计新增数据，如果有统计数据更新数据。
 */
@RestController
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        Visitor visitor = visitorRepository.findByIp(ip);
        if(visitor == null){
            visitor=new Visitor();
            visitor.setIp(ip);
            visitor.setTimes(1);
        }else{
            visitor.setTimes(visitor.getTimes()+1);
        }
        visitorRepository.save(visitor);
        return "I have been seen ip "+visitor.getIp()+" "+visitor.getTimes()+" times.";
    }

}
