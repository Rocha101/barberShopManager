import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ScheduleDTO {

    @NotNull
    private  Integer id;

    private Customer customer;

    private User user;

    private Event events;

    private List<Service> services;

    private Location location;

}