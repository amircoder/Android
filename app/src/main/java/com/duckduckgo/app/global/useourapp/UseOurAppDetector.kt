/*
 * Copyright (c) 2020 DuckDuckGo
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

package com.duckduckgo.app.global.useourapp

import android.net.Uri
import androidx.core.net.toUri
import com.duckduckgo.app.global.baseHost
import javax.inject.Inject

class UseOurAppDetector @Inject constructor() {

    fun isUseOurAppUrl(url: String?): Boolean {
        if (url == null) return false
        return isUseOurAppUrl(url.toUri())
    }

    private fun isUseOurAppUrl(uri: Uri): Boolean {
        return domainMatchesUrl(uri, USE_OUR_APP_DOMAIN) || domainMatchesUrl(uri, USE_OUR_APP_MOBILE_DOMAIN)
    }

    private fun domainMatchesUrl(uri: Uri, matchingUrl: String): Boolean {
        return uri.baseHost == matchingUrl.toUri().baseHost
    }

    companion object {
        const val USE_OUR_APP_SHORTCUT_URL: String = "https://m.facebook.com"
        const val USE_OUR_APP_SHORTCUT_TITLE: String = "Facebook"
        const val USE_OUR_APP_DOMAIN = "facebook.com"
        const val USE_OUR_APP_MOBILE_DOMAIN = "m.facebook.com"
    }
}