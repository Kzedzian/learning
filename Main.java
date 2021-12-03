package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> people = takeInputAndReturnShuffledArray();
        printSecretSantaList(people);
    }

    public static ArrayList<String> takeInputAndReturnShuffledArray() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile osób bierze udział w wymianie prezentów?");
        int numberOfPeople = 0;

        if (scanner.hasNextInt()) {
            numberOfPeople = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Nieprawidłowa liczba");
            return null;
        }

        int counter = 0;
        ArrayList<String> people = new ArrayList<>();

        while (counter < numberOfPeople) {
            System.out.println("Podaj imię");
            String name = scanner.nextLine();
            if (name.length() > 0) {
                people.add(name);
                counter++;
            } else {
                System.out.println("Za krótkie imię!");
            }
        }
        Collections.shuffle(people);
        return people;
    }

    public static void printSecretSantaList(ArrayList<String> people) {

        if(people == null){
            System.out.println("Coś poszło nie tak!");
        }

        int arrayLength = people.size();
        ArrayList<String> peopleToChoose = new ArrayList<>(people);
        Random random = new Random();
        int numberOfPeopleToChoseFrom = arrayLength;

        for (int i = 0; i < arrayLength; i++) {
            boolean assignmentSuccessful = false;
            while (!assignmentSuccessful) {
                int randomNumber = random.nextInt(numberOfPeopleToChoseFrom);
                if (!peopleToChoose.get(randomNumber).equals(people.get(i))) {
                    System.out.println(people.get(i) + " kupuje prezent dla " + peopleToChoose.get((randomNumber)));
                    peopleToChoose.remove(randomNumber);
                    numberOfPeopleToChoseFrom--;
                    assignmentSuccessful = true;

                }
            }
        }
    }
}
