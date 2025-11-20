package Model.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {

    private String CustID;
    private String CustTitel;
    private String CustName;
    private String DOB;
    private String Salary;
    private String CustAddress;
    private String City;
    private String Province;
    private String PostalCode;

}
