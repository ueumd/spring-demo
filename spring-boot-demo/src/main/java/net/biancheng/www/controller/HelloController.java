package net.biancheng.www.controller;

import net.biancheng.www.bean.Person;
import net.biancheng.www.bean.PersonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private Person person;

    @Autowired
    PersonValue personValue;

    @Value("${name}")
    private String name;

    @Value("${person.lastName}")
    private String name2;

    @ResponseBody
    @RequestMapping("/hello")
    public List<String> hello() {
        List<String> list = new ArrayList<>();
        list.add(this.name);
        list.add(this.name2);
        return list;
    }

    @ResponseBody
    @GetMapping("/getPerson")
    public Person getPerson() {
        return person;
    }

    @ResponseBody
    @GetMapping("/getPersonValue")
    public PersonValue getPersonValue() {
        return personValue;
    }
}
