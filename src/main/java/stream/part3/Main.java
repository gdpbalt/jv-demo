package stream.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    StreamApiAdvanced api = new StreamApiAdvanced();

    //    int[] basicInput = new int[]{1, 4, 7, 10, 35, 97, 31, 55, 17, 74, 2, 10};
    //    System.out.println(api.filterAndReverse(basicInput));

    //    List<Person> personList = new Main().initPeopleList();
    //    System.out.println(api.groupByAge(personList));

    List<String> basicInput =
        List.of(
            "g23",
            "gregory",
            "abcdg",
            "11victory",
            "_christmas_",
            "republic16",
            "future!",
            "compilation",
            "convention",
            "exhibition",
            "fate");
    System.out.println(api.groupWordsByLastChar(basicInput));

    System.out.println("Ok");
  }

  private List<Person> initPeopleList() {
    List<Person> people = new ArrayList<>();
    Person jess = new Person("Jess", 48, Person.Sex.WOMAN, initCatList());
    people.add(jess);
    Person nick = new Person("Nick", 22, Person.Sex.MAN, initCatList());
    people.add(nick);
    Person joe = new Person("Joe", 25, Person.Sex.MAN, Collections.emptyList());
    people.add(joe);
    Person mary = new Person("Mary", 16, Person.Sex.WOMAN, initCatList());
    people.add(mary);
    Person susy = new Person("Susy", 37, Person.Sex.WOMAN, List.of(new Cat("Kitty", 5)));
    people.add(susy);
    Person barry = new Person("Barry", 29, Person.Sex.MAN, initCatList());
    people.add(barry);
    Person hillary = new Person("Hillary", 48, Person.Sex.WOMAN, List.of(new Cat("Chris", 13)));
    people.add(hillary);
    return people;
  }

  private List<Cat> initCatList() {
    Cat tommy = new Cat("Tommy", 5);
    Cat snow = new Cat("Snow", 2);
    Cat jackie = new Cat("Jackie", 15);
    return List.of(tommy, snow, jackie);
  }
}
