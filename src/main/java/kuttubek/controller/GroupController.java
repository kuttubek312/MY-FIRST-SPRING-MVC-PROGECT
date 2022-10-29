package kuttubek.controller;

import kuttubek.model.Course;
import kuttubek.model.Group;
import kuttubek.service.CompanyService;
import kuttubek.service.CourseService;
import kuttubek.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller

public class GroupController {

    private final CompanyService companyService;
    private final GroupService groupService;
    private final CourseService courseService;

    @Autowired
    public GroupController(CompanyService companyService, GroupService groupService, CourseService courseService) {
        this.companyService = companyService;
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @GetMapping("/getGroups")
    public String getAllGroups(@RequestParam("companyId") Long id, Model model){
        List<Group> groups = new ArrayList<>();
        for(Group i: groupService.getAllGroup()){
            try{
                if(Objects.equals(i.getCompany().getId(), id)){
                    groups.add(i);
                }
            }
            catch(NullPointerException e){
                System.out.println("It is null");
            }
        }
        model.addAttribute("groups", groups);
        return "groups/groups";
    }

    @GetMapping("/addGroup")
    public String addGroup(@RequestParam("companyId") Long id,Model model){
        model.addAttribute("group",new Group());
        model.addAttribute("courses",companyService.getById(id).getCourses());
        return "groups/addGroup";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@RequestParam("companyId") Long id, @ModelAttribute("group") Group group,
                            @RequestParam(value = "courses" , required = false) String[] courses){
        List<Course> courseList = new ArrayList<>();
        group.setCompany(companyService.getById(id));
        try{
            for (String course : courses) {
                courseList.add(courseService.getById((long) Integer.parseInt(course)));
            }
        }
        catch(NullPointerException e){
            System.out.println("It is null!");
        }
        group.setCourseList(courseList);
        groupService.saveGroup(group);
        return "redirect:/getGroups?companyId="+id;
    }

    @GetMapping("/updateGroup")
    public String updateGroup(@RequestParam("groupId") Long groupId ,@RequestParam("companyId") Long companyId,Model model){
        model.addAttribute("group",groupService.getById(groupId));
        model.addAttribute("courses",companyService.getById(companyId).getCourses());
        return "groups/updateGroup";
    }

    @PostMapping("/saveUpdateGroup")
    public String saveUpdateGroup(@RequestParam("companyId") Long id, @ModelAttribute("group") Group group,
                                  @RequestParam(value = "courss" , required = false) String[] courses){
        List<Course> courseList = new ArrayList<>();
        group.setCompany(companyService.getById(id));
        try{
            for (String course : courses) {
                courseList.add(courseService.getById((long) Integer.parseInt(course)));
            }
        }
        catch(NullPointerException e){
            System.out.println("Courses selected is null!");
        }
        group.setCourseList(courseList);
        groupService.updateGroup(id,group);
        return "redirect:/getGroups?companyId="+id;
    }

    @RequestMapping("/deleteGroup")
    public String deleteGroup(@RequestParam("groupId") Long groupId, @RequestParam("companyId") Long companyId){
        groupService.removeGroupById(groupId);
        return "redirect:/getGroups?companyId="+companyId;
    }

}
