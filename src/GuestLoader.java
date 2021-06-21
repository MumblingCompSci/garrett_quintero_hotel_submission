import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class GuestLoader {
    private HashMap<Long, Guest> guests = new HashMap<>(); // id, guest

    public Set<Long> guests() { return guests.keySet(); }

    public void load(String filename) throws ParseException, IOException {
        JSONParser parser = new JSONParser();

        // generates working directory path + file name
        String path = (new File("").getAbsolutePath()) + "/"
                + filename;
        System.out.println("Using: " + path);

        // guests.json is structured as an array of guests containing another array representing their reservation
        JSONArray guestArray = (JSONArray) parser.parse(new FileReader(path));

        int count = 0;
        for (Object guestObject : guestArray) {
            Guest guest = new Guest();
            guest.setId((Long) ((JSONObject) guestObject).get(Guest.ID)); // set guest ID

            // check for duplicate guest ID
            // skip guest if ID already exists
            if (guests.containsKey(guest.getId())) {
                System.err.println("Guest with ID: " + guest.getId() + " already exists, Skipping!");
                continue;
            }

            guest.setFirstName((String) ((JSONObject) guestObject).get(Guest.FIRST));
            guest.setLastName((String) ((JSONObject) guestObject).get(Guest.LAST));

            // extract and create reservation
            JSONObject jsonReservation = (JSONObject) ((JSONObject) guestObject).get(Guest.RESERVATION);
            guest.reservation.setRoomNumber((Long) jsonReservation.get(Guest.ROOM));
            guest.reservation.setStartTimestamp((Long) jsonReservation.get(Guest.START));
            guest.reservation.setEndTimestamp((Long) jsonReservation.get(Guest.END));

            // guest is complete, add to map
            guests.put(guest.getId(), guest);
            count++;
        }
        System.out.println("Loaded " + count + " guests!");
    }

    public Guest getGuest(long guestID) {
        if (guests.containsKey(guestID)) return guests.get(guestID);
        else return null;
    }
}
