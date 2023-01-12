package com.wizeline.onsite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class HelloWorldTests {

  @Test
  public void helloWorld() {
    assertThat("Hello world", is("Hello world"));
  }
}
