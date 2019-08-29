package boot.spring.controller;

import boot.spring.pagemodel.ActorGrid;
import boot.spring.pagemodel.PersonGrid;
import boot.spring.po.Actor;
import boot.spring.po.Person;
import boot.spring.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Simida
 * @create: 2019-08-04 12:16
 **/
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value="/person",method= RequestMethod.GET)
    @ResponseBody
    public PersonGrid selectAll(@RequestParam(value="current")int current,@RequestParam("rowCount") int rowCount){
        PersonGrid personGrid = new PersonGrid ();
        List<Person> ls = personService.selectAll ();
        personGrid.setRows (ls);
        personGrid.setCurrent (1);
        personGrid.setRowCount (100);
        personGrid.setTotal (100);

        return personGrid;
    }
    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);
    @ApiOperation("获取所有演员列表")
    @RequestMapping(value="/showperson",method=RequestMethod.GET)
    @ResponseBody
    public PersonGrid showperson(){
        PersonGrid personGrid = new PersonGrid ();
        List<Person> ls = personService.selectAll ();
        personGrid.setRows (ls);
        personGrid.setCurrent (1);
        personGrid.setRowCount (100);
        personGrid.setTotal (100);


    LOG.debug("获取所有演员列表");
        return personGrid;
}
@RequestMapping(value = "/person/insert",method = RequestMethod.POST)
@ResponseBody
    public int insert(@RequestBody Person person){
        return personService.insert (person);
}
@RequestMapping(value = "/person/update",method = RequestMethod.POST)
@ResponseBody
    public void update(@RequestBody Person person){
        personService.update (person);
}
@RequestMapping(value = "/person/delete",method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestParam long actor_id){
        personService.delete (actor_id);
}
}

