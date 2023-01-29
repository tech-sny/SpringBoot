package life.care.health.azure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import life.care.health.fileUpload.FileService;
import life.care.health.azure.Employee;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class SpringbootAzuresqlApplication {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    FileService fileService;
    @Autowired
    private ObjectMapper mapper;

    
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public Employee createCondition(@RequestPart("data") String employee,@RequestPart("image") MultipartFile image) throws IOException{
        String img = fileService.upload(image, "prefix");
        Employee e = mapper.readValue(employee,Employee.class);
        e.setImage(img);
        return repository.save(e);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return repository.findAll();
    }


}
