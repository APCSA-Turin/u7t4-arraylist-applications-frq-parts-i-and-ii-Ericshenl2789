package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {
    
    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        for(int i = 0; i <list.size() - 1; i++){
            for(int j = 0; j < list.size() - i - 1; j++){
                if(list.get(j).getLastName().compareTo(list.get(j + 1).getLastName()) > 0){
                    Student temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
                if(list.get(j).getLastName().equals(list.get(j+1).getLastName())){
                    if(list.get(j).getFirstName().compareTo(list.get(j + 1).getFirstName()) > 0){
                        Student temp = list.get(j);
                        list.set(j, list.get(j+1));
                        list.set(j+1, temp);
                    }
                }
                if(list.get(j).getFirstName().equals(list.get(j+1).getFirstName())){
                    if(list.get(j).getGpa() < list.get(j + 1).getGpa()){
                        Student temp = list.get(j);
                        list.set(j, list.get(j+1));
                        list.set(j+1, temp);
                    }
                }

            }
        }
        return list;
    }

}
