package com.learn.java.junit5.jsonpath;

import static com.jayway.jsonpath.JsonPath.*;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
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
        List<String> findElementsByAge24 = context.read("$.[?(@.age==24)]");
        assertThat(findElementsByAge24).hasSize(2);
        System.out.println("findElementsByAge24: "+findElementsByAge24);
//        String s = findElementsByAge24.get(0);
        
//        Employee[] e = objectMapper.readValue((JsonParser) findElementsByAge24, Employee[].class);
        //assertThat(e.getName()).isEqualTo("name2");
//        List<String>  empArray = context.read("$.[?(@.age==24)]");
//        List<Employee> find2ElementsByAge24 = objectMapper.readValue((JsonParser) empArray, new TypeReference<List<Employee>>(){});
//        System.out.println("name: "+find2ElementsByAge24.getClass().getName());
//        assertThat(find2ElementsByAge24).hasSize(2);
//        System.out.println("find2ElementsByAge24: "+find2ElementsByAge24);
//        assertThat(find2ElementsByAge24.get(0).getName()).isEqualTo("name2");
//        assertThat(find2ElementsByAge24.get(1).getName()).isEqualTo("name3");

    }
}
