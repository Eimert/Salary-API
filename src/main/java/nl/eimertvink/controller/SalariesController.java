package nl.eimertvink.controller;

import io.swagger.v3.oas.annotations.Parameter;
import nl.eimertvink.entity.Salaries;
import nl.eimertvink.repository.SalariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salaries")
public class SalariesController extends AbstractController {

    private final SalariesRepository salariesRepository;

    @Autowired
    public SalariesController(SalariesRepository salariesRepository) {
        this.salariesRepository = salariesRepository;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Page<Salaries> findAll(@Parameter(example = "{\n" +
        "  \"page\": 0,\n" +
        "  \"size\": 10,\n" +
        "  \"sort\": [\n" +
        "    \"name,asc\"\n" +
        "  ]\n" +
        "}") @PageableDefault(sort = {"name"}) Pageable pageable) {
        return salariesRepository.findAll(pageable);
    }

}
