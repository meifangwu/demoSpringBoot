package com.willa.demo.dao;

import com.willa.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 伪装DB 实现PersonDao
 * 新增用户
 */

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID uuid) {
//        return Optional.empty();
        return DB.stream()
                .filter(person -> uuid.equals(person.getId()))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID uuid) {
        Optional<Person> personResult = selectPersonById(uuid);
        if(personResult.isPresent()){
            //存在
            DB.remove(personResult.get());
            return 1;
        }
        return 0;
    }


}
