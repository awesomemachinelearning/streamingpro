/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.support.ui;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * Abstraction around {@link Thread#sleep(long)} to permit better testability.
 */
public interface Sleeper {

  Sleeper SYSTEM_SLEEPER = duration -> Thread.sleep(duration.toMillis());

  /**
   * Sleeps for the specified duration of time.
   *
   * @deprecated use {@link #sleep(java.time.Duration)}
   *
   * @param duration How long to sleep.
   * @throws InterruptedException If the thread is interrupted while sleeping.
   */
  @Deprecated
  default void sleep(Duration duration) throws InterruptedException {
    sleep(java.time.Duration.of(duration.in(TimeUnit.MILLISECONDS), ChronoUnit.MILLIS));
  }

  /**
   * Sleeps for the specified duration of time.
   *
   * @param duration How long to sleep.
   * @throws InterruptedException If the thread is interrupted while sleeping.
   */
  void sleep(java.time.Duration duration) throws InterruptedException;
}
