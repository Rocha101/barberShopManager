import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustumerDTO {

    @NotNull
    private  Integer id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String username;

    @NotEmpty
    private String phone;

    private List<Event> status;

    private List<Sale> sales;

}