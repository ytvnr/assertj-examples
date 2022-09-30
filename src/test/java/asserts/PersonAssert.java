package asserts; /**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.ytvnr.Person;
import org.assertj.core.api.AbstractAssert;

/**
 * A class providing a set of assertions for the {@link io.ytvnr.Person} object
 * @author Yann TAVERNIER (yann.tavernier at graviteesource.com)
 * @author GraviteeSource Team
 */
public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

    public PersonAssert(Person actual) {
        super(actual, PersonAssert.class);
    }

    public static PersonAssert assertThat(Person actual) {
        return new PersonAssert(actual);
    }

    public PersonAssert hasName(String name) {
        isNotNull();
        if (!actual.getName().equals(name)) {
            failWithMessage("Expected person to have name %s but was %s", name, actual.getName());
        }
        return this;
    }

    public PersonAssert hasStreet(String street) {
        isNotNull();
        final String actualStreet = actual.getHome() == null ? null : actual.getHome().getAddress() == null ? null : actual.getHome().getAddress().getStreet();
        if (street == null || !street.equals(actualStreet)) {
            failWithMessage("Expected person to have street %s but was %s", street, actualStreet);
        }
        return this;
    }
}
