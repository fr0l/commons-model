/*
 * Copyright 2019 EPAM Systems
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

package com.epam.ta.reportportal.ws.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class NotNullMapValueValidator implements ConstraintValidator<NotNullMapValue, Map<?, ?>> {

	@Override
	public void initialize(NotNullMapValue constraintAnnotation) {
	}

	@Override
	public boolean isValid(Map<?, ?> value, ConstraintValidatorContext context) {
		if (null == value) {
			return true;
		}
		for (Object obj : value.values()) {
			if (null == obj) {
				return false;
			}
		}
		return true;
	}
}
