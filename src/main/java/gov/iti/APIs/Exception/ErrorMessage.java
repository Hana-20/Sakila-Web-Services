package gov.iti.APIs.Exception;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ErrorMessage {
 private String errorMessage;
 private int errorCode;
 private String errorDescription;

}
