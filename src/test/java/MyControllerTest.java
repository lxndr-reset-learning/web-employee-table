import com.reset.spring.mvc_hibernate_aop.controller.MyController;
import com.reset.spring.mvc_hibernate_aop.entity.Employee;
import com.reset.spring.mvc_hibernate_aop.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyControllerTest {

    @InjectMocks
    private MyController myController;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private Model model;

    private Employee employee;
    private List<Employee> allEmployees;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        allEmployees = List.of(new Employee(), new Employee());
    }

    @Test
    void testShowAllEmployees() {
        when(employeeService.getAllEmployees()).thenReturn(allEmployees);

        String viewName = myController.showAllEmployees(model);

        Assertions.assertEquals("all-employees-view", viewName);
    }

    @Test
    void testAddNewEmployee() {
        String viewName = myController.addNewEmployee(model);

        Assertions.assertEquals("employee-info", viewName);
    }

    @Test
    void testSaveEmployee() {
        String viewName = myController.saveEmployee(employee);

        Assertions.assertEquals("redirect:/showAllEmployees", viewName);
        verify(employeeService).saveEmployee(employee);
    }

    @Test
    void testUpdateEmployee() {
        when(employeeService.getEmployeeById(1)).thenReturn(employee);

        String viewName = myController.updateEmployee(1, model);

        Assertions.assertEquals("employee-info", viewName);
    }

    @Test
    void testDeleteEmployee() {
        String viewName = myController.deleteEmployee(1);

        Assertions.assertEquals("redirect:/showAllEmployees", viewName);
        verify(employeeService).deleteEmployeeById(1);
    }
}