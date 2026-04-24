package com.mister_webhooks.pluggable_credentials_provider;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class DummySource10 implements Provider {
  public static class Provider implements AwsCredentialsProvider {

    @Override
    public AwsCredentials resolveCredentials() {
      return null;
    }
  }

  @Override
  public boolean available() {
    return true;
  }

  @Override
  public Integer priority() {
    return 10;
  }

  @Override
  public AwsCredentialsProvider build() {
    return new Provider();
  }
}
