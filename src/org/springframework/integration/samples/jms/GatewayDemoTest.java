/*
 * Copyright 2002-2017 the original author or authors.
 *
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
 */

package org.springframework.integration.samples.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.util.Assert;

/**
 * @author Gunnar Hillert
 */
public class GatewayDemoTest {

  private final static String[] configFilesGatewayDemo = {
      "common.xml",
      "inboundGateway.xml",
      "outboundGateway.xml"
  };

  public static void main(String[] args) {

    System.setProperty("spring.profiles.active", "testCase");

    final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        configFilesGatewayDemo,GatewayDemoTest.class);

    final MessageChannel stdinToJmsOutChannel = applicationContext
        .getBean("stdinToJmsOutChannel", MessageChannel.class);

    stdinToJmsOutChannel.send(MessageBuilder.withPayload("jms test"+System.currentTimeMillis()).build());

    final QueueChannel queueChannel = applicationContext
        .getBean("queueChannel", QueueChannel.class);

    @SuppressWarnings("unchecked")
    Message<String> reply = (Message<String>) queueChannel.receive(20000);
    System.out.println(reply.getPayload());
    applicationContext.close();
  }

}
