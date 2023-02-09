package life.care.health.azure.Education;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import life.care.health.fileUpload.FileService;

@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    FileService fileService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    private List<Education> findAllProject(){
        return educationRepository.findProjects();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public Education saveProject(@RequestPart("data") String data,@RequestPart("image") MultipartFile image) throws JsonMappingException, JsonProcessingException{
        
        String img = fileService.upload(image, "project");
        Education payload = mapper.readValue(data, Education.class);
        payload.setImage(img);
        return educationRepository.save(payload);
    }
    
}