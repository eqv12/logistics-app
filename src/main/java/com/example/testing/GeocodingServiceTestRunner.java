//package com.example.testing;
//
//import com.example.model.AddressRequest;
//import com.example.service.GeocodingService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component // Makes this a Spring-managed bean
//public class GeocodingServiceTestRunner implements CommandLineRunner {
//
//    private static final Logger log = LoggerFactory.getLogger(GeocodingServiceTestRunner.class);
//
//    private final GeocodingService geocodingService; // Inject the service
//
//    // Spring will inject the concrete implementation (NominatimGeocodingServiceImpl)
//    public GeocodingServiceTestRunner(GeocodingService geocodingService) {
//        this.geocodingService = geocodingService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        log.info("--- Starting GeocodingService Test ---");
//
//        // Create an AddressRequest object
//        AddressRequest address1 = new AddressRequest();
//        address1.setStreet("PSG College of Technology");
//        address1.setCity("Coimbatore");
//        address1.setState("Tamil Nadu");
//        address1.setPinCode("641004");
//
//
//        log.info("Testing with Address 1: {}", address1);
//        GeocodingService.Coordinates coordinates1 = geocodingService.geocode(address1);
//        log.info("Coordinates for Address 1: {}", coordinates1); // Will be (0.0, 0.0) for now
//
//        log.info("-----------------------------------------");
////
////        AddressRequest address2 = new AddressRequest();
////        // Example: A well-known landmark that Nominatim should find
////        // Note: Without parsing yet, this will also return (0.0, 0.0) from your current service
////        address2.setStreet("Eiffel Tower");
////        address2.setCity("Paris");
////        // address2.setState(""); // Optional if city/country are specific enough
////        // address2.setPinCode("");
////
////        log.info("Testing with Address 2 (Eiffel Tower, Paris): {}", address2);
////        GeocodingService.Coordinates coordinates2 = geocodingService.geocode(address2);
////        log.info("Coordinates for Address 2: {}", coordinates2); // Will be (0.0, 0.0) for now
//
//
//        log.info("--- GeocodingService Test Finished ---");
//        // The application will terminate after all CommandLineRunners complete (if it's not a web app that stays running)
//    }
//}