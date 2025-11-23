package Model.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {

    private String CustID;
    private String CustTitle;  // FIXED: correct spelling
    private String CustName;
    private String DOB;
    private double Salary;
    private String CustAddress;
    private String City;
    private String Province;
    private String PostalCode;

}
