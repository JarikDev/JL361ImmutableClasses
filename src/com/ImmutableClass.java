package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyImmutable myImmutable=new MyImmutable(5,new ArrayList<>(),"hello",new Person());
        myImmutable.getPerson().age=10;
        System.out.println(myImmutable.getPerson().age);
    }

    final static class MyImmutable {
        private final int i;
        private final List<String> list;
        private final String str;
        private final Person person;

        public int getI() {
            return i;
        }

        public List<String> getList() {
            return list;
        }

        public String getStr() {
            return str;
        }

        public Person getPerson() throws CloneNotSupportedException {
            return (Person) person.clone();
        }

        public MyImmutable(int i, List<String> list, String str, Person person ) throws CloneNotSupportedException {
            this.i = i;
            this.list = Collections.unmodifiableList(cloneList(list));
            this.str = str;
            this.person = (Person)person.clone();

        }
        private List<String> cloneList(List<String> list){
            List<String> clone=new ArrayList<>();
            for (String s:list) {
                clone.add(s);
            }
            return clone;
        }
    }

    static class Person implements Cloneable{
        int age;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
