package javax.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import junit.framework.Assert;

import org.codelabor.example.validation.dto.PersonDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {
		"file:src/main/resources/spring/applicationContext-root.xml",
		"file:src/main/resources/spring/applicationContext-myBatis.xml",
		"file:src/test/resources/spring/applicationContext-dataSource.xml",
		"file:src/main/resources/spring/applicationContext-security.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidatorTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ValidatorTest.class);
	private static Validator validator;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private PersonDto personDto = null;

	@Before
	public void setUp() throws Exception {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testValidateSource() throws Exception {
		String username = "ob1";
		String password = "!QAZ2wsx";
		String confirmPassword = "!QAZ2wsx";
		String firstName = "<td>Obi-Wan</td>";
		String lastName = "Kenobi";
		String email = "xxxx@xxx.xxx";
		String confirmEmail = "yyyy@xxx.xxx";
		String phone = "010-1111-1111";
		Date birthDate = (new SimpleDateFormat("yyyy-MM-dd"))
				.parse("1900-01-01");

		personDto = new PersonDto();
		personDto.setUsername(username);
		personDto.setPassword(password);
		personDto.setPasswordConfirm(confirmPassword);
		personDto.setFirstName(firstName);
		personDto.setLastName(lastName);
		personDto.setEmail(email);
		personDto.setEmailConfirm(confirmEmail);
		personDto.setMobilePhone(phone);
		personDto.setBirthDate(birthDate);

		Set<ConstraintViolation<PersonDto>> constraintViolations = validator
				.validate(personDto);

		logger.error("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.error("message: {}", violation.getMessage());
		}

		Assert.assertEquals(2, constraintViolations.size());
	}
}