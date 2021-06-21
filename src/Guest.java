
public class Guest {

    public static final String ID = "id";
    public static final String FIRST = "firstName";
    public static final String LAST = "lastName";
    public static final String ROOM = "roomNumber";
    public static final String START = "startTimestamp";
    public static final String END = "endTimestamp";
    public static final String RESERVATION = "reservation";

    public class Reservation {
        private long roomNumber;
        private long startTimestamp;
        private long endTimestamp;

        public Reservation() {
            roomNumber = startTimestamp = endTimestamp = 0L;
        }

        public long getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(long roomNumber) {
            this.roomNumber = roomNumber;
        }

        public long getStartTimestamp() {
            return startTimestamp;
        }

        public void setStartTimestamp(long startTimestamp) {
            this.startTimestamp = startTimestamp;
        }

        public long getEndTimestamp() {
            return endTimestamp;
        }

        public void setEndTimestamp(long endTimestamp) {
            this.endTimestamp = endTimestamp;
        }
    }

    private long id;
    private String firstName;
    private String lastName;

    // assuming one reservation per guest
    public Reservation reservation;

    public Guest() {
        this.reservation = new Reservation();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
