/*
 * Copyright 2019 Immutables Authors and Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.immutables.criteria.repository.async;

import org.immutables.criteria.backend.Backend;
import org.immutables.criteria.expression.Query;
import org.immutables.criteria.repository.MapperFunction4;
import org.immutables.criteria.repository.reactive.ReactiveMapper4;

public class AsyncMapper4<T1, T2, T3, T4> {

  private final ReactiveMapper4<T1, T2, T3, T4> delegate;

  AsyncMapper4(Query query, Backend.Session session) {
    this.delegate = new ReactiveMapper4<>(query, session);
  }

  public <R> AsyncFetcher<R> map(MapperFunction4<T1, T2, T3, T4, R> mapFn) {
    return new AsyncFetcher<R>(delegate.map(mapFn));
  }
}
