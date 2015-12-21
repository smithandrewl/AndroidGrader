package org.androidgrader.app.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java8.util.Optional;

import java.util.Date;

@DatabaseTable(tableName = "WorkLogEntry")
public class WorkLogEntry {
    @DatabaseField(canBeNull = false, unique = true)
    Date start;

    @DatabaseField(unique=true)
    Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Optional<Date> getEnd() {
        return Optional.ofNullable(end);
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Optional<Date> elapsedTime() {
        Optional<Date> endDate = Optional.ofNullable(end);

        return endDate.map(date -> date == null ? null : new Date(date.getTime() - start.getTime()));
    }
}
