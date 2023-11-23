import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EventDTO {

    @NotNull
    private  Integer id;

    @NotEmpty
    private String description;

    @NotEmpty
    private String title;

    private Date startTime;

    private Date endTime;

    private User user;

    private Customer customer;

    private Service service;

    private Schedule schedule;


}