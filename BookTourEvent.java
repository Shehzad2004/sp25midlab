
public class Tour {
    // Event class
public class BookTourEvent {
    private String customerName;
    private String destination;
    
    public BookTourEvent(String customerName, String destination) {
        this.customerName = customerName;
        this.destination = destination;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDestination() {
        return destination;
    }
}

// Observer interface
public interface TourBookingObserver {
    void onTourBooked(BookTourEvent event);
}

// Subject class
public class TourBookingSystem {
    private List<TourBookingObserver> observers = new ArrayList<>();

    // Method to add observers
    public void addObserver(TourBookingObserver observer) {
        observers.add(observer);
    }

    // Method to remove observers
    public void removeObserver(TourBookingObserver observer) {
        observers.remove(observer);
    }

    // Method to trigger the event (Book Tour)
    public void bookTour(String customerName, String destination) {
        BookTourEvent event = new BookTourEvent(customerName, destination);
        notifyObservers(event);  // Notify all observers about the event
    }

    // Notify all observers about the event
    private void notifyObservers(BookTourEvent event) {
        for (TourBookingObserver observer : observers) {
            observer.onTourBooked(event);
        }
    }
}

}


   
