package com.example.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DataRepo;
import com.example.entity.StudentEntity;

@Controller
public class HomeContoller {

	@Autowired 
	DataRepo srepo;
	
	@RequestMapping("/mainpage")
	public String main() {
		return "mainpage";
	}
	
	@RequestMapping("/searchpage")
	public String searchpage() {
		return "search";
	}
	@RequestMapping("/uploadpage")
	public String uploadpage() {
		return "insert";
	}
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	@RequestMapping("/findall")
	public String find() {
		return "findall";
	}
	
	@RequestMapping("/searchfunction")
	public String searchfunction(@RequestParam String searchby,@RequestParam String searchvalue, Model model) {
		
		List<StudentEntity> data = null;
		
		if (searchby.equalsIgnoreCase("id")) {
		    Optional<StudentEntity> temp = srepo.findById(Integer.parseInt(searchvalue));
		    data = temp.isPresent() ? Collections.singletonList(temp.get()) : Collections.emptyList();
		} else if (searchby.equalsIgnoreCase("name")) {
		    data = srepo.findByName(searchvalue);
		} else if (searchby.equalsIgnoreCase("branch")) {
		    data = srepo.findByBranch(searchvalue);
		} else if (searchby.equalsIgnoreCase("college")) {
		    data = srepo.findByCollege(searchvalue);
		} else if(searchby.equalsIgnoreCase("city")) {
			data = srepo.findByCity(searchvalue);
		} else {
		    data = Collections.emptyList();
		}

		model.addAttribute("students",data);
		return "search";
	}
	@RequestMapping("/insertfunction")
	public String insert(StudentEntity studdata, Model model) {
		StudentEntity isDone = srepo.save(studdata);
		if(isDone!=null) {
			model.addAttribute("showmessage",true);
		}
		else {
			model.addAttribute("showmessage",false);
		}
		return "insert";
	}
	@RequestMapping("/updatefunction")
	public String updatefunc(@RequestParam String id, @RequestParam String updateby, @RequestParam String updatevalue, Model model) {
	    
	    Integer studentId = Integer.parseInt(id);
	    Optional<StudentEntity> temp = srepo.findById(studentId);
	    
	    if (temp.isPresent()) {
	        StudentEntity student = temp.get();

	        if (updateby.equalsIgnoreCase("name")) {
	            student.setName(updatevalue);
	        } else if (updateby.equalsIgnoreCase("branch")) {
	            student.setBranch(updatevalue);
	        } else if (updateby.equalsIgnoreCase("college")) {
	            student.setCollege(updatevalue);
	        } else if (updateby.equalsIgnoreCase("city")) {
	            student.setCity(updatevalue);
	        } else {
	            model.addAttribute("error", "Invalid field specified for update.");
	            return "update";
	        }

	        srepo.save(student);
	        model.addAttribute("message", "Student Data updated successfully!");
	    } else {
	        model.addAttribute("error", "Student not found with ID: " + id);
	    }
	    return "update";
	}
	@RequestMapping("/deletefunction")
	public String delete(@RequestParam String deleteby, @RequestParam String deleteBy, Model model) {
	        switch (deleteby.toLowerCase()) {
	            case "id":
	                Optional<StudentEntity> temp = srepo.findById(Integer.parseInt(deleteBy));
	                if (temp.isPresent()) {
	                    srepo.deleteById(Integer.parseInt(deleteBy));
	                    model.addAttribute("message", "Student with ID " + deleteBy + " has been deleted successfully.");
	                } else {
	                    model.addAttribute("message", "User with given ID: " + deleteBy + " not found.");
	                }
	                break;
	            case "name":
	                List<StudentEntity> studentsByName = srepo.findByName(deleteBy);
	                if (studentsByName.isEmpty()) {
	                    model.addAttribute("message", "No students found with name: " + deleteBy);
	                } else {
	                    for (StudentEntity student : studentsByName) {
	                        srepo.delete(student);
	                    }
	                    model.addAttribute("message", "Students with name " + deleteBy + " have been deleted successfully.");
	                }
	                break;
	            case "branch":
	                List<StudentEntity> studentsByBranch = srepo.findByBranch(deleteBy);
	                if (studentsByBranch.isEmpty()) {
	                    model.addAttribute("message", "No students found in branch: " + deleteBy);
	                } else {
	                    for (StudentEntity student : studentsByBranch) {
	                        srepo.delete(student);
	                    }
	                    model.addAttribute("message", "Students in branch " + deleteBy + " have been deleted successfully.");
	                }
	                break;
	            case "college":
	                List<StudentEntity> studentsByCollege = srepo.findByCollege(deleteBy);
	                if (studentsByCollege.isEmpty()) {
	                    model.addAttribute("message", "No students found from college: " + deleteBy);
	                } else {
	                    for (StudentEntity student : studentsByCollege) {
	                        srepo.delete(student);
	                    }
	                    model.addAttribute("message", "Students from college " + deleteBy + " have been deleted successfully.");
	                }
	                break;
	            case "city":
	                List<StudentEntity> studentsByCity = srepo.findByCity(deleteBy);
	                if (studentsByCity.isEmpty()) {
	                    model.addAttribute("message", "No students found from city: " + deleteBy);
	                } else {
	                    for (StudentEntity student : studentsByCity) {
	                        srepo.delete(student);
	                    }
	                    model.addAttribute("message", "Students from city " + deleteBy + " have been deleted successfully.");
	                }
	                break;
	            default:
	                model.addAttribute("error", "Invalid field specified for deletion.");
	                break;
	        }
	    return "delete"; 
		}
	@RequestMapping("/findalldatafunc")
	public String findall(Model model) {
		List<StudentEntity> students = (List<StudentEntity>) srepo.findAll();
		model.addAttribute("students",students);
		return "findall";
	}
	}
