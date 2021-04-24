package com.willa.demo.service;

import com.willa.demo.dao.PersonDao;
import com.willa.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Slf4j
public class PersonService {

    @Autowired @Qualifier("fakeDao")
    private  PersonDao personDao;

    public int addPerson(Person person){
//        int i = personDao.insertPerson(person);
//        return i;
        log.info("add person = {}", person);
        return personDao.addPerson(person);
    }


    public List<Person> getAllPeople(){
        log.info("get all people =={}",personDao.selectAllPeople().toString());
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        log.info("getPersonById 的id= {}, and result={}",id, personDao.selectPersonById(id).orElse(null));
        return personDao.selectPersonById(id);
    }

    public int deletePesonById(UUID id){
        log.info("开始删除用户ById ={}",id);
        return personDao.deletePersonById(id);
    }
}
