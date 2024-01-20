/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.camunda.connector;

import static org.junit.jupiter.api.Assertions.*;

import io.camunda.connector.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LocalConnectorRuntime.class)
public class JpaTest {

  @Autowired UserRepository userRepository;

  @Test
  public void findUserTest() {
    var user1 = userRepository.findById(Long.valueOf(1));
    assertNotNull(user1);
    assertEquals("user1@email.com", user1.get().getEmail());
  }

  @Test
  public void selectCountTest() {
    var user1 = userRepository.findById(Long.valueOf(1));
    assertNotNull(user1);
    assertEquals("user1@email.com", user1.get().getEmail());
  }
}
