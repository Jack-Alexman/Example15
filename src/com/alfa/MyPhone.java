package com.alfa;

import java.util.Arrays;
import java.util.Comparator;

public class MyPhone {
    private MyPhoneBook book;

    public MyPhone() {
        book = new MyPhoneBook();
    }

    public class MyPhoneBook {

        private PhoneRecord[] phoneRecords =
                new PhoneRecord[10];
        private int counterRecords = 0;

        class PhoneRecord{
            private String name;
            private String phone;

            public PhoneRecord(String name, String phone) {
                this.name = name;
                this.phone = phone;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public String getPhone() {
                return phone;
            }
            public void setPhone(String phone) {
                this.phone = phone;
            }
            @Override
            public String toString() {
                return "name = " + name +
                        ", phone = " + phone;
            }
        }
        public boolean addPhoneNumber(String name, String phone){
            if (counterRecords < phoneRecords.length){
                phoneRecords[counterRecords++] =
                        new PhoneRecord(name, phone);
                return true;
            }
            return false;
        }

        public void printPhoneRecord(){
            for (int i = 0; i <counterRecords; i++){
                System.out.println(phoneRecords[i]);
            }
        }

        private void printPhoneRecord(PhoneRecord[] array){
            for (PhoneRecord phoneRecord: array
            ) {
                System.out.println(phoneRecord);

            }
        }

        public void sortByName(){
            PhoneRecord[] newRecords = Arrays.copyOf(phoneRecords, counterRecords);
            Arrays.sort(newRecords, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    String name1 = ((PhoneRecord)o1).getName();
                    String name2 = ((PhoneRecord)o2).getName();
                    return name1.compareTo(name2);
                }
            });
            printPhoneRecord(newRecords);
        }

    }

    public void swichOn(){
        System.out.println("Loading PhoneBook records...");
        book.addPhoneNumber("Eugen", "0998765432");
        book.addPhoneNumber("Inna", "0771284764");
        book.addPhoneNumber("Alla", "0221987563");
        book.addPhoneNumber("Lera", "0773950674");
        book.addPhoneNumber("Yuzik", "0958715263");
        book.addPhoneNumber("Vovchik", "0668796453");
        System.out.println("Loading is complite.");
    }
}
