package org.cukesalad.rest.support;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import static org.hamcrest.Matchers.*;

import org.cukesalad.rest.support.RestContext;
import org.cukesalad.rest.support.RestHook;
import org.junit.Test;

public class RestHookTest {

  @Test
  public void testRefresh() throws ParserConfigurationException {
    RestHook.refresh();
    assertNull(RestContext.clientResponse);
    assertNull(RestContext.method);
    assertNull(RestContext.postBody);
    assertNull(RestContext.restResponse);
    assertNull(RestContext.webresource);
    assertThat(RestContext.headerMapList.toArray(), arrayWithSize(0));
    assertTrue(RestContext.restProps.isEmpty());
  }
  
  @Test
  public void testBefore() throws ParserConfigurationException {
    System.setProperty("env", "junit");
    System.setProperty("prop3", "restsalad.sysprop");

    RestHook restHook = new RestHook();
    restHook.beforeHook();
    
    assertNull(RestContext.clientResponse);
    assertNull(RestContext.method);
    assertNull(RestContext.postBody);
    assertNull(RestContext.restResponse);
    assertNull(RestContext.webresource);
    assertThat(RestContext.headerMapList.toArray(), arrayWithSize(0));
    assertEquals("restsalad", RestContext.restProps.get("prop1"));
    assertEquals("restsalad.junit", RestContext.restProps.get("prop2"));
    assertEquals("restsalad.sysprop", RestContext.restProps.get("prop3"));
  }
  
  
  @Test
  public void testAfter() throws IOException, ParserConfigurationException {

    RestHook restHook = new RestHook();
    restHook.afterHook();
    
    assertNull(RestContext.clientResponse);
    assertNull(RestContext.method);
    assertNull(RestContext.postBody);
    assertNull(RestContext.restResponse);
    assertNull(RestContext.webresource);
    assertThat(RestContext.headerMapList.toArray(), arrayWithSize(0));
    assertTrue(RestContext.restProps.isEmpty());
  }

}
