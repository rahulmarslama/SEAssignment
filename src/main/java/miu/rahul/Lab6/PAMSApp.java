package miu.rahul.Lab6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PAMSApp {
    public static void main(String[] args) throws Exception {
        Patient[] patient = new Patient[5];
        patient[0] = new Patient(
                "Daniel", "Agar",
                LocalDate.of(1987, 1, 19),
                "(641) 123-0009",
                "dagar@m.as",
                "1 N Street"
        );

        patient[1] = new Patient(
                "Ana", "Smith",
                LocalDate.of(1948, 12, 5),
                null,
                "amsith@te.edu",
                null
        );

        patient[2] = new Patient(
                "Marcus", "Garvey",
                LocalDate.of(2001, 9, 18),
                "(123) 292-0018",
                null,
                "4 East Ave"
        );

        patient[3] = new Patient(
                "Jeff", "Goldbloom",
                LocalDate.of(1995, 2, 28),
                "(999) 165-1192",
                "jgold@es.co.za",
                null
        );

        patient[4] = new Patient(
                "Mary", "Washington",
                LocalDate.of(1932, 5, 31),
                null,
                null,
                "30 W Burlington"
        );

        LocalDate today = LocalDate.now();

        List<Map<String, Object>> jsonPatients = Arrays.stream(patient)
                .sorted(Comparator.comparingInt((Patient p) -> calculateAge(p.getDOB(), today)).reversed())
                .map(p -> {
                    Map<String, Object> row = new LinkedHashMap<>();
                    row.put("firstName", p.getFirstName());
                    row.put("lastName", p.getLastName());
                    row.put("dateOfBirth", p.getDOB().toString());
                    row.put("contactNumber", p.getContactNumber());
                    row.put("email", p.getEmail());
                    row.put("mailingAddress", p.getMailingAddress());
                    row.put("age", calculateAge(p.getDOB(), today));
                    return row;
                })
                .collect(Collectors.toList());

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String jsonOutput = mapper.writeValueAsString(jsonPatients);

        System.out.println(jsonOutput);
    }

    private static int calculateAge(LocalDate dob, LocalDate today) {
        return Period.between(dob, today).getYears();
    }
}

