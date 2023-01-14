package com.wizeline.onsite;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HelloWorldTests {

  @Test
  public void helloWorld() {
    assertThat("Hello world", is("Hello world"));
  }
}
