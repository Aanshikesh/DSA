class BusBooking {
    private final Map<String, Integer> bookings = new HashMap<>();  // seat -> cost at the moment it was booked
    private int total = 0;

    public BusBooking(int n) {}

    public void toggle(String seat) {
        if (bookings.containsKey(seat)) {
            total -= bookings.remove(seat);  // free it: only its own cost leaves
            return;
        }
        char label = seat.charAt(0);
        String middle = (label == 'A' ? "B" : label == 'D' ? "C" : "") + seat.substring(1);  // window -> its middle seat; for B/C just the row, never a key
        bookings.put(seat, bookings.containsKey(middle) ? 3 : 1);
        total += bookings.get(seat);
    }

    public int getTotalTime() { return total; }

    public int getMinTime() { return bookings.size(); }  // windows first, then middles: every seat costs 1
}