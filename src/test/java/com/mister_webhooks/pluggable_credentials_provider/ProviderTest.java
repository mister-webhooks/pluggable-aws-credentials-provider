package com.mister_webhooks.pluggable_credentials_provider;

import org.testng.annotations.Test;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

import static org.testng.Assert.assertEquals;

public class ProviderTest {
  @Test
  public void testGetProvider() {
    AwsCredentialsProvider provider = Provider.getProvider();

    assertEquals(provider.getClass(), DummySource10.Provider.class);
  }
}