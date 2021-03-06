/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package de.interseroh.tmb.applauncher.client.common;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import javax.inject.Singleton;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class ErrorFormatter {

	private static final Logger logger = Logger
			.getLogger(ErrorFormatter.class.getName());

	public void showError(Throwable exception, String inputMessage) {
		String message =
				inputMessage + exception + " - " + exception.getMessage()
						+ "Stack trace: " + stackTraceToString(exception);
		logger.log(Level.SEVERE, message);
		Notify.notify(message);
	}

	private String stackTraceToString(Throwable e) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append('\n');
		}
		return sb.toString();
	}
}
