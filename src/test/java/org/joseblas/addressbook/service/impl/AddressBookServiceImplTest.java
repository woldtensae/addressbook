package org.joseblas.addressbook.service.impl;

import org.joseblas.addressbook.model.Gender;
import org.joseblas.addressbook.model.Person;
import org.joseblas.addressbook.service.AddressBookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;

public class AddressBookServiceImplTest {

    private List<Person> people = new ArrayList<>();
    private AddressBookService addressbook;

    @Before
    public void setUp() throws Exception {
        people.add(Person.createPerson("Rosa", Gender.Female, "03/07/1980"));
        people.add(Person.createPerson("Maria", Gender.Female, "23/01/1983"));
        people.add(Person.createPerson("Tabo", Gender.Male, "16/04/1978"));
        people.add(Person.createPerson("Domi", Gender.Male, "16/04/1979"));
        addressbook = new AddressBookServiceImpl(people);

    }

    @Test
    public void countByGenderFemaleTest(){
        assertEquals("Two females", 2L, addressbook.countByGender(Gender.Female).longValue());
    }

    @Test
    public void countByGenderMaleTest(){
        assertEquals("Two females", 2L, addressbook.countByGender(Gender.Male).longValue());
    }


    @Test
    public void getOlder(){
        Optional<Person> person = addressbook.getOldestPerson();
        Assert.assertTrue("There are data", person.isPresent());
        Assert.assertEquals("Is Tabo", "Tabo", person.get().getName());
    }
}