/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2019
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
package it.infn.mw.iam.api.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.infn.mw.iam.persistence.repository.IamGroupRepository;

@Component
@Scope("prototype")
public class IamGroupNameValidator implements ConstraintValidator<IamGroupName, String> {

  @Autowired
  private IamGroupRepository groupRepository;

  @Override
  public void initialize(IamGroupName constraintAnnotation) {
    // empty method
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && groupRepository.findByName(value).isPresent();
  }
}
