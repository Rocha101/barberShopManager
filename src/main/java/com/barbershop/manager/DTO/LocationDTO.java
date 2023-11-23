import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class createLocationDTO {

    @NotNull
    private  Integer id;

    @NotEmpty
    private String description;

    @NotEmpty
    private String user;

    @NotEmpty
    private String schedules;

    private Date createdAt;

    private Date updatedAt;


}