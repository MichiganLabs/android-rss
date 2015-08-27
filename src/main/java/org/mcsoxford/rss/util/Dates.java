/*
 * Copyright (C) 2010 A. Horn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mcsoxford.rss.util;

import org.mcsoxford.rss.RSSFault;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Internal helper class for date conversions.
 *
 * @author Mr Horn
 */
public final class Dates {

  /**
   * @see <a href="http://www.ietf.org/rfc/rfc0822.txt">RFC 822</a>
   */
  private static final SimpleDateFormat RFC822 = new SimpleDateFormat(
      "EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

  private static final SimpleDateFormat ISO8601 = new SimpleDateFormat(
      "yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);

  /* Hide constructor */
  private Dates() {}

  /**
   * Parses string as an RFC 822 date/time.
   *
   * @throws RSSFault if the string is not a valid RFC 822 date/time
   */
  public static Date parseRfc822(String date) {
    try {
      return RFC822.parse(date);
    } catch (ParseException e) {
      throw new RSSFault(e);
    }
  }

  public static Date parseIso8601(String date) {
    try {
      return ISO8601.parse(date);
    } catch (ParseException e) {
      throw new RSSFault(e);
    }
  }
}

