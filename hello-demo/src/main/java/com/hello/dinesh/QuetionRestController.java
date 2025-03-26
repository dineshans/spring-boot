package com.hello.dinesh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuetionRestController {

    List<String> globalList = new ArrayList<>();
    @GetMapping("/quetions")
    public List<String> qeutions(){

        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("Dinesh");

        globalList.addAll(list);

         return globalList;
    }
}
