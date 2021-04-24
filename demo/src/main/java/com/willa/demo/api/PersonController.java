package com.willa.demo.api;

import com.willa.demo.model.Person;
import com.willa.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }


    @PostMapping("/hello")
    public void helloWorld(){
        System.out.println("hello world");
    }


    @GetMapping("/getAllPeople")
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @PostMapping("/getPersonById")
    public Person getPersonById(@RequestParam("id") String id){
        UUID uuid = null;

        try{
            uuid = UUID.fromString(id);

        }catch (Exception e){
            throw e;
        }
        return personService.getPersonById(uuid).orElse(null);
    }


    @PostMapping(path = "/deletePersonById")
    public void deletePersonById(@RequestParam("id") String id){
        try{
            UUID uuid = UUID.fromString(id);
            personService.deletePesonById(uuid);
        }catch (Exception e){
            throw e;
        }
    }


}

