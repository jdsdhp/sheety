/*
 * Copyright (c) 2020 jesusd0897.
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

package com.jesusd0897.sheety.util

import android.view.View

internal fun View.setSafeOnClickListener(onSafeClick: ((View) -> Unit)?) {
    val safeClickListener = SafeClickListener {
        if (onSafeClick != null) onSafeClick(it)
    }
    setOnClickListener(if (onSafeClick != null) safeClickListener else null)
}

internal fun View.setSafeOnLongClickListener(onSafeLongClick: ((View) -> Unit)?): Boolean {
    val safeClickListener = SafeLongClickListener {
        if (onSafeLongClick != null) onSafeLongClick(it)
    }
    setOnLongClickListener(if (onSafeLongClick != null) safeClickListener else null)
    return true
}

