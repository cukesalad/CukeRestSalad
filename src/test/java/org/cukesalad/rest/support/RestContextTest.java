package org.cukesalad.rest.support;

import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.Assert.*;

import org.cukesalad.rest.support.RestContext;
import org.junit.Test;

public class RestContextTest {

  @Test
  public void testRefresh() {
    RestContext.refresh();
    assertNull(RestContext.clientResponse);
    assertNull(RestContext.method);
    assertNull(RestContext.postBody);
    assertNull(RestContext.restResponse);
    assertNull(RestContext.webresource);
    assertThat(RestContext.headerMapList.toArray(), arrayWithSize(0));
    assertTrue(RestContext.restProps.isEmpty());
  }

}