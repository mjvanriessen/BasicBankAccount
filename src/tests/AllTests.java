/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Jan 24, 2023
 */
package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ AccountRegistryTest.class, MemberRegistryTest.class })
public class AllTests {

}
