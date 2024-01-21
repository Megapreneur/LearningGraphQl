package com.uncledaimmy.learninggraphql;

import com.uncledaimmy.learninggraphql.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void canFindUserByEmail() {
        this.graphQlTester
                .document("{ findUserByEmail(email: \"showboy@gmail.com\") { userId name email gender age } }")
                .execute()
                .path("findUserByEmail")
                .matchesJson("""
                        {
                          "userId": 1,
                          "name": "Adekunle Shobowale",
                          "email": "showboy@gmail.com",
                          "gender": "MALE",
                          "age": 33
                        }""");
    }
}
