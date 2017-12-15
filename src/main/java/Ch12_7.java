import java.time.LocalDateTime;

public class Ch12_7 {
    class TimeInterval {
        private final LocalDateTime start;
        private final LocalDateTime end;

        public TimeInterval(LocalDateTime start, LocalDateTime end) {
            if (start.isAfter(end)) {
                throw new IllegalArgumentException("Start can not be after end");
            }
            this.start = start;
            this.end = end;
        }

        public boolean overlap(TimeInterval other) {
            if (this.start.isBefore(other.start) && this.end.isAfter(other.start)) {
                return true;
            } else if (other.start.isBefore(this.start) && other.end.isAfter(this.start)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
