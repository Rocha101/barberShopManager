import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BuyerInfoDTO {

    @NotNull
    private  Integer id;

    @NotEmpty
    private String name;

    private String phone;

    @NotEmpty
    private String document;

    @NotEmpty
    private String status;

    private List<Sale> sales;

}