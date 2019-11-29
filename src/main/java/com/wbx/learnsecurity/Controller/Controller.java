package com.wbx.learnsecurity.Controller;/*
 *@author 王炳祥
 *@createTime
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "level1/"+id;
    }
}
