/*
 * Copyright 2001-2013 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package org.scalatest.words

import org.scalatest.Resources
import org.scalatest.MatchersHelper.checkExpectedException
import org.scalatest.MatchersHelper.indicateSuccess
import org.scalatest.Assertion
import org.scalatest.Succeeded

/**
 * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
 * the matchers DSL.
 *
 * @author Bill Venners
 */
final class ResultOfBeWordForAnType[T](clazz: Class[T]) {
  
  /**
   * This method enables the following syntax: 
   *
   * <pre class="stHighlight">
   * an [Exception] should be thrownBy { ... }
   *                          ^
   * </pre>
   */
  def thrownBy(fun: => Unit): Assertion = {
    // SKIP-SCALATESTJS-START
    val stackDepth = 1
    // SKIP-SCALATESTJS-END
    //SCALATESTJS-ONLY val stackDepth = 14
    checkExpectedException(fun, clazz, Resources.wrongException _, Resources.exceptionExpected _, stackDepth)
    indicateSuccess(Resources.exceptionThrown(clazz.getName))
  }
  
  /**
   * Overrides toString to return pretty an[...] should/must be
   */
  override def toString: String = "ResultOfBeWordForAnType(classOf[" + clazz.getName + "])"
}
