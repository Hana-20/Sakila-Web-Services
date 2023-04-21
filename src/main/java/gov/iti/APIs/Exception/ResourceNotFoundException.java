package gov.iti.APIs.Exception;

import jakarta.xml.ws.WebFault;

@WebFault
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
    super(message);
    }
   }
   