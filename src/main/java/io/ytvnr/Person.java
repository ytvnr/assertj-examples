/**
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
package io.ytvnr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Yann TAVERNIER (yann.tavernier at graviteesource.com)
 * @author GraviteeSource Team
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
// Getter needed for Hamcrest assertions
@Getter
public class Person {
    String name;
    double height;
    Home home = new Home();

    public static Person buildSherlock() {
        return Person.builder()
            .name("Sherlock")
            .height(1.80)
            .home(
                Home.builder()
                    .ownedSince(new Date(123))
                    .address(
                        Address.builder()
                            .street("Baker Street")
                            .number(221)
                            .build()
                    )
                    .build()
            ).build();
    }
}
