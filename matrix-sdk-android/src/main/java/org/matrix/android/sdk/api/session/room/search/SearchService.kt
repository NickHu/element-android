/*
 * Copyright 2020 New Vector Ltd
 * Copyright 2020 The Matrix.org Foundation C.I.C.
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

package org.matrix.android.sdk.api.session.room.search

import org.matrix.android.sdk.api.MatrixCallback
import org.matrix.android.sdk.api.util.Cancelable
import org.matrix.android.sdk.internal.session.room.search.response.SearchResponse

/**
 * This interface defines methods to search messages in rooms.
 */
interface SearchService {

    /**
     * Generic function to search a term in multiple rooms.
     * Ref: https://matrix.org/docs/spec/client_server/latest#module-search
     * @param searchTerm the term to search
     * @param rooms roomIds to search term inside
     * @param nextBatch the token that retrieved from the previous response. Should be provided to get the next batch of results
     * @param limit the maximum number of events to return.
     * @param beforeLimit how many events before the result are returned.
     * @param afterLimit how many events after the result are returned.
     * @param includeProfile requests that the server returns the historic profile information for the users that sent the events that were returned.
     */
    fun search(searchTerm: String,
               rooms: List<String>,
               nextBatch: String?,
               orderByRecent: Boolean,
               limit: Int,
               beforeLimit: Int,
               afterLimit: Int,
               includeProfile: Boolean,
               callback: MatrixCallback<SearchResponse>): Cancelable
}
