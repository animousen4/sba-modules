package com.animousen4.game.engine.core.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class DateTimeUtil {
    public Date getCurrentDate() {
        ZoneId zone = ZoneId.of("Europe/Minsk");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
        return Date.from(zonedDateTime.toInstant());
    }

    public Date getDateWithDuration(Date date, Duration duration) {
        return Date.from(date.toInstant().plus(duration));
    }
}
