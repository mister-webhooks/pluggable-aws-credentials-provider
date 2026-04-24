package com.mister_webhooks.pluggable_credentials_provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Vector;

public interface Provider {
  boolean available();
  Integer priority();
  AwsCredentialsProvider build();

  static AwsCredentialsProvider getProvider() {
    final Logger logger = LoggerFactory.getLogger(Provider.class);

    ServiceLoader<Provider> loader = ServiceLoader.load(Provider.class);

    List<Provider> candidates = new Vector<>();

    for (Provider candidate: loader) {
      logger.debug("Considering {} -> priority={} enabled={}", candidate, candidate.priority(), candidate.available());
      if (candidate.available()) {
        candidates.add(candidate);
      }
    }

    candidates.sort(Comparator.comparing(Provider::priority));

    return candidates.getFirst().build();
  }
}
