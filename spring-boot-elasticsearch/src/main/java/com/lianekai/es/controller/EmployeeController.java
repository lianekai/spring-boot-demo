package com.lianekai.es.controller;

import com.google.gson.Gson;
import com.lianekai.es.pojo.Employee;
import com.lianekai.es.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/05/18 23:41
 */
@RestController
@RequestMapping("/es")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("add")
    public String add(){
        Employee employee=Employee.of()
                .setId("1")
                .setAbout("lianyikai111111")
                .setAge(25)
                .setFirstName("lian")
                .setLastName("yikai");
        employeeRepository.save(employee);
        return "save success";
    }
    @GetMapping("getOne")
    public Employee getOne(){
        Optional<Employee> employee=employeeRepository.findById("1");
        return employee.get();
    }
    /**
     * 删除
     * @return
     */
    @GetMapping("delete")
    public String delete() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employeeRepository.delete(employee);
        return "success";
    }

    /**
     * 局部更新
     * @return
     */
    @GetMapping("update")
    public String update() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        employeeRepository.save(employee);
        System.err.println("update a obj");
        return "success";
    }
    /**
     * 查询
     * @return
     */
    @GetMapping("query")
    public Employee query() {
        Employee accountInfo = employeeRepository.queryEmployeeById("1");
        System.err.println(new Gson().toJson(accountInfo));
        return accountInfo;
    }


}
