import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class createProductDTO {

    @NotNull
    private  Integer id;

    private Long customerInfoId;

    private Float totalPrice;

    private Date createdAt;

    private Date updatedAt;

    private BuyerInfo customerInfo;

    private User user;

    private List<Product> products;

}