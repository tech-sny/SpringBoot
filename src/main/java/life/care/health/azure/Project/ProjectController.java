package life.care.health.azure.Project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import life.care.health.fileUpload.FileService;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    FileService fileService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    private List<Project> findAllProject(){
        return projectRepository.findProjects();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public Project saveProject(@RequestPart("data") String data,@RequestPart("image") MultipartFile image) throws JsonMappingException, JsonProcessingException{
        
        String img = fileService.upload(image, "project");
        Project payload = mapper.readValue(data, Project.class);
        payload.setImage(img);
        return projectRepository.save(payload);
    }
    
}
