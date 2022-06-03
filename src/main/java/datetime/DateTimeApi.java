package datetime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeApi {
  public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
  public static final int GET_DATE_OF_NUMBER_ARRAY_ELEMENTS = 3;
  public static final int GET_DATE_INDEX_YEAR = 0;
  public static final int GET_DATE_INDEX_MONTH = 1;
  public static final int GET_DATE_INDEX_DAY = 2;
  public static final String PARSE_DATE_FORMAT = "yyyyMMdd";
  public static final String CUSTOM_PARSE_DATE_FORMAT = "d MMM yyyy";
  public static final String FORMAT_DATE_FORMAT = "dd MMMM yyyy HH:mm";

  /**
   * Return the current date as a String depending on a query.
   *
   * <p>The query can be passed for the whole date or for it's part: - FULL - current date as a
   * whole: year, month, day of month formatted as `YYYY-MM-DD` (a default return value); - YEAR -
   * current year; - MONTH - name of the current month; - DAY - current day of month; In any other
   * case throw DateTimeException.
   */
  public String todayDate(DateTimePart datePart) {
    LocalDate now = LocalDate.now();
    //noinspection EnhancedSwitchMigration
    switch (datePart) {
      case YEAR:
        return String.valueOf(now.getYear());
      case MONTH:
        return now.getMonth().getDisplayName(TextStyle.FULL, DEFAULT_LOCALE).toUpperCase();
      case DAY:
        return String.valueOf(now.getDayOfMonth());
      case HOURS:
      case MINUTES:
      case SECONDS:
        throw new DateTimeException("Error input parameters");
      default:
        return now.format(ISO_LOCAL_DATE);
    }
  }

  /**
   * Given an Array of 3 elements, where - 1-st element is a `year`; - 2-nd element is s `month`; -
   * 3-rd element is a `day of month`;
   *
   * <p>Return LocalDate built from these elements. If Array contains more than 3 elements - throw
   * DateTimeException.
   */
  public LocalDate getDate(Integer[] dateParams) {
    if (dateParams == null || dateParams.length != GET_DATE_OF_NUMBER_ARRAY_ELEMENTS) {
      throw new DateTimeException("Error input parameters");
    }
    return LocalDate.of(
        dateParams[GET_DATE_INDEX_YEAR],
        dateParams[GET_DATE_INDEX_MONTH],
        dateParams[GET_DATE_INDEX_DAY]);
  }

  /** Given the time and the number of hours to add, return the changed time. */
  public LocalTime addHours(LocalTime localTime, Integer hoursToAdd) {
    return localTime.plusHours(hoursToAdd);
  }

  /** Given the time and the number of minutes to add, return the changed time. */
  public LocalTime addMinutes(LocalTime localTime, Integer minutesToAdd) {
    return localTime.plusMinutes(minutesToAdd);
  }

  /** Given the time and the number of seconds to add, return the changed time. */
  public LocalTime addSeconds(LocalTime localTime, Integer secondsToAdd) {
    return localTime.plusSeconds(secondsToAdd);
  }

  /** Given the date and the number of weeks to add, return the changed date. */
  public LocalDate addWeeks(LocalDate localDate, Integer numberOfWeeks) {
    return localDate.plusWeeks(numberOfWeeks);
  }

  /**
   * Given a random `someDate` date, return one of the following Strings: - "`someDate` is after
   * `currentDate`" if `someDate` is in the future relating to the `current date`; - "`someDate` is
   * before `currentDate`" if `someDate` is in the past relating to the `current date`; -
   * "`someDate` is today" if `someDate` is today;
   */
  public String beforeOrAfter(LocalDate someDate) {
    LocalDate currentDate = LocalDate.now();
    if (someDate.equals(currentDate)) {
      return String.format("%s is today", someDate);
    }
    return someDate.isAfter(currentDate)
        ? String.format("%s is after %s", someDate, currentDate)
        : String.format("%s is before %s", someDate, currentDate);
  }

  /**
   * Given a String representation of a date and some timezone, return LocalDateTime in this
   * timezone.
   */
  public LocalDateTime getDateInSpecificTimeZone(String dateInString, String zone) {
    ZonedDateTime parsedDateTime = ZonedDateTime.parse(dateInString);
    ZoneId parsedZone = ZoneId.of(zone);
    return parsedDateTime.withZoneSameInstant(parsedZone).toLocalDateTime();
  }

  /**
   * Given some LocalDateTime, return an OffsetDateTime with the local time offset applied (`+02:00`
   * for Ukraine).
   *
   * <p>Example: we receive a LocalDateTime with a value `2019-09-06T13:17`. We should return the
   * OffsetDateTime with a value `2019-09-06T13:17+02:00`, where `+02:00` is the offset for our
   * local timezone.
   *
   * <p>OffsetDateTime is recommended to use for storing date values in a database.
   */
  public OffsetDateTime offsetDateTime(LocalDateTime localTime) {
    return OffsetDateTime.of(localTime, ZoneOffset.of("+02"));
  }

  /** Given a String formatted as `yyyyMMdd`, return LocalDate object built from this String. */
  public LocalDate parseDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PARSE_DATE_FORMAT);
    return LocalDate.parse(date, formatter);
  }

  /**
   * Given a String formatted as `d MMM yyyy` (MMM - Sep, Oct, etc), return LocalDate object built
   * from this String.
   */
  public LocalDate customParseDate(String date) {
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern(CUSTOM_PARSE_DATE_FORMAT, DEFAULT_LOCALE);
    return LocalDate.parse(date, formatter);
  }

  /**
   * Given some LocalDateTime, return a String formatted as `day(2-digit) month(full name in
   * English) year(4-digit) hours(24-hour format):minutes`.
   *
   * <p>Example: "01 January 2000 18:00".
   */
  public String formatDate(LocalDateTime dateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_FORMAT, DEFAULT_LOCALE);
    return dateTime.format(formatter);
  }
}
