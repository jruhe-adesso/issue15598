package de.ruhe;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("e")
public class IssueApplicationTest {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${my.property}")
    private String myProprerty;

    @Autowired
    private Environment environment;

    @Test
    public void shouldActivateProfileE() throws Exception {
        Assertions.assertThat(activeProfile).isEqualTo("e");
    }

    @Test
    public void shouldHaveProfilesActiveDevE() throws Exception {
        Assertions.assertThat(environment.getActiveProfiles()).containsExactly("dev","e");
    }

    @Test
    public void shouldReturnPropertyOfProfileE() throws Exception {
        Assertions.assertThat(myProprerty).isEqualTo("eValue");
    }
}