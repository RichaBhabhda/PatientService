package com.richa.hospital;

import com.richa.hospital.controller.PatientController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HospitalControllerApplicationTest {

    @Autowired
    PatientController controller;

    @ParameterizedTest
    @ValueSource(strings = {
            "77c0845c-3884-48df-bb10-d16d8c96b7dc",
            "aa1682ad-1ba2-442f-b2eb-393580d0a109",
            "aa1682ad-1ba2-442f-b2eb-393580d0a109"
    })
    public void getPatientByIdTest(String id)
    {
        assertNotNull(controller.getPatientById(id));
    }

    @Test
    public void getPatientByIdTest()
    {
        assertNotNull(controller.getAllPatients());
    }


}
