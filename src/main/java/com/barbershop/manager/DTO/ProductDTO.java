import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class createProductDTO {

    @NotNull
    private  Integer id;

    @NotEmpty
    private String description;

    @NotNull
    private Float price;

    @NotNull
    private String quantity;

    @NotEmpty
    private Date status;


}