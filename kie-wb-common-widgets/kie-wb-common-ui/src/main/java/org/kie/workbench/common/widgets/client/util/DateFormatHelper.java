/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.widgets.client.util;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

public class DateFormatHelper {

    public static String shortFormat( long timestamp ) {
        return format( timestamp, DateTimeFormat.PredefinedFormat.DATE_TIME_SHORT );
    }

    public static String format( long timestamp, DateTimeFormat.PredefinedFormat format ) {
        return DateTimeFormat.getFormat( format ).format(
                new Date( timestamp ) );
    }
}