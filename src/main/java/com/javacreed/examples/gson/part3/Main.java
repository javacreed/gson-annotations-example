/*
 * #%L
 * Gson Annotations Example
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.gson.part3;

import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
  public static void main(final String[] args) throws Exception {
    final GsonBuilder builder = new GsonBuilder();
    builder.setVersion(1.0);
    final Gson gson = builder.create();

    final SoccerPlayer account = new SoccerPlayer();
    account.setName("Albert Attard");
    account.setShirtNumber(10); // Since version 1.2
    account.setTeamName("Zejtun Corinthians");
    account.setCountry("Malta"); // Until version 0.9

    final String json = gson.toJson(account);
    System.out.printf("Serialised (version 1.0)%n  %s%n", json);

    try (final Reader data = new InputStreamReader(Main.class.getResourceAsStream("/part3/player.json"), "UTF-8")) {
      // Parse JSON to Java
      final SoccerPlayer otherPlayer = gson.fromJson(data, SoccerPlayer.class);
      System.out.println("Deserialised (version 1.0)");
      System.out.printf("  Name:          %s%n", otherPlayer.getName());
      System.out.printf("  Shirt Number:  %s (since version 1.2)%n", otherPlayer.getShirtNumber());
      System.out.printf("  Team:          %s%n", otherPlayer.getTeamName());
      System.out.printf("  Country:       %s (until version 0.9)%n", otherPlayer.getCountry());
    }
  }
}
