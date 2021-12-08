package com.lianekai.es.repository;

import com.lianekai.es.pojo.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/05/18 23:38
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    Employee queryEmployeeById(String id);
}
