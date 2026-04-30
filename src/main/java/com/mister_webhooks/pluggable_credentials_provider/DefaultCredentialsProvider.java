package com.mister_webhooks.pluggable_credentials_provider;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class DefaultCredentialsProvider implements Provider {

  public DefaultCredentialsProvider(){}

  @Override
  public boolean available() {
    return true;
  }

  @Override
  public Integer priority() {
    return Integer.MAX_VALUE;
  }

  @Override
  public AwsCredentialsProvider build() {
    return software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider.builder().build();
  }
}
