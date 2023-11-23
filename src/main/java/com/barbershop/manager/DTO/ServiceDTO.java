import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDTO {

    @NotNull
    private  Integer id;

    private String email;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String phone;

    private String startTime;

    private String endTime;

    private List<Event> events;

    private List<Service> services;

    private List<Product> products;

    private List<Schedule> schedules;

    private List<Sale> sales;

    private List<Location> locations;

}