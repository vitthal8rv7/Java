package com.learn.java.junit5.jsonpath;

import static com.jayway.jsonpath.JsonPath.*;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.learn.java.junit5.model.Employee;
import static org.assertj.core.api.Assertions.*;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class JsonPathTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testJsonPath() throws Exception {
        List<Employee> employeeList = Arrays.asList(
                new Employee("id1", "name1", 22),
                new Employee("id2", "name2", 24),
                new Employee("id3", "name3", 24));
        String employees = objectMapper.writeValueAsString(employeeList);

        DocumentContext context = parse(employees);

        Integer length = context.read("$.length()");
        assertThat(length).isEqualTo(3);
        assertThat("name1").isEqualTo(context.read("$[0].name"));
        List<String> ids = context.read("$..id");
        System.out.println("ids: "+ids);
        assertThat(ids).containsExactly("id1", "id2", "id3");
        assertThat(ids).contains("id1", "id2");
        List<String> first2Elements = context.read("$.[0:2]");
        assertThat(first2Elements).hasSize(2);
        //employeeList.add(new Employee("id4", "name4", 24));
        Employee[] findElementsByAge24 = context.read("$.[?(@.age==24)]", Employee[].class);
        System.out.println("findElementsByAge24: "+Arrays.toString(findElementsByAge24));
        System.out.println("first object name: "+findElementsByAge24[0].getName());
        System.out.println("second object name: "+findElementsByAge24[1].getName());
        assertThat(findElementsByAge24).hasSize(2);
        System.out.println("findElementsByAge24: "+findElementsByAge24);
        ReadContext ctx = JsonPath.parse(employeeList);
        System.out.println("employeeList: "+employeeList);
        System.out.println("employees: "+employees);
        System.out.println("ctx: "+ctx.jsonString());
        String name = context.read("$[0].name");
        System.out.println("name: "+name);
        Employee[] name2 = context.read("$[?(@.name == 'name3')]", Employee[].class);
        System.out.println("name2: "+name2[0].getName());

        //Integer age = ctx.read("$.employee.age");
        //String department = ctx.read("$.employee.department");
        //List<String> skills = ctx.read("$.employee.skills");
    }
}
