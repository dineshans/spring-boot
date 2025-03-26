package com.eureka.emp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController extends Exception{

    List<String> list = new ArrayList<>();

    @GetMapping("/empList")
    public List<String> getEmpDetails(){

        List<String> empList =  new ArrayList<>();

        empList.add("Associates");
        empList.add("AVP");

        list.addAll(empList);

        return list;
    }


}
