package com.homeworkphoneb.utils;

import com.homeworkphoneb.models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    public DataProviders() throws FileNotFoundException {
    }

    @DataProvider
    public Iterator<Object[]> createNewAccountWithCsv() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/NewUser.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0])
                .setLastName(split[1])
                .setEmail(split[2])
                .setPassword(split[3])
                .setConfirmPassword(split[4])});
            line = reader.readLine();

        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> exsistedUserRegistrationWithCsv() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/NewUser.csv")));

    String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPassword(split[4])});
            line = reader.readLine();

        }
        return list.iterator();

}

}
