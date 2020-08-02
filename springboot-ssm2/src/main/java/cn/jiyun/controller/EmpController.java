package cn.jiyun.controller;

import cn.jiyun.pojo.Dept;
import cn.jiyun.pojo.Emp;
import cn.jiyun.service.DeptService;
import cn.jiyun.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Value("${file.upload.path}")
    private String filePath;
    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;
    @GetMapping("test")
    @ResponseBody
    public String test(){
        return  "hello world";
    }
    @GetMapping("toAddEmp")
    public String toAddEmp(Model model){
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        return  "addEmp";
    }
    @PostMapping("addEmp")
    public String addEmp(@ModelAttribute(value = "emp")Emp emp,
                         @RequestParam(value = "file")MultipartFile file) throws IOException {
        //获取名称
        String filename = file.getOriginalFilename();
        System.out.println();
        File photoFile = new File(filePath, filename);
        //判断当前系统是否上传图片,如果不存在则新建
        if(!photoFile.getParentFile().exists()){
            photoFile.getParentFile().mkdirs();
        }
        file.transferTo(new File(filePath+File.separator+filename));
        emp.setPhoto("/123photo/"+filename);
        empService.addEmp(emp);
        //保存完员工数据后 跳转到展示页面
        System.out.println(filename);
        return  "redirect:/emp/findAll";

    }
    @GetMapping("findAll")
    public String findAll(Model model){
        List<Emp> emps = empService.findAll();
        System.out.println("ccc="+emps);
        model.addAttribute("emps",emps);
        return  "empList";
    }
    @GetMapping("delEmpById")
    public String delEmpById(@RequestParam(value = "eid" )Integer eid){
        empService.delEmpById(eid);
        return  "redirect:/emp/findAll";

    }
    @GetMapping("findById")
    public  String findById(Integer eid,Model model){
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        Emp emp=empService.findById(eid);
        model.addAttribute("emp",emp);
       return "updateEmp";
    }
    @PostMapping("updateEmp")
    public String updateEmp(Emp emp, @RequestParam(value = "file") MultipartFile file) throws IOException {
        //获取名称
        String filename = file.getOriginalFilename();
        System.out.println();
        File photoFile = new File(filePath, filename);
        //判断当前系统是否上传图片,如果不存在则新建
        if(!photoFile.getParentFile().exists()){
            photoFile.getParentFile().mkdirs();
        }
        file.transferTo(new File(filePath+File.separator+filename));
        emp.setPhoto("/123photo/"+filename);
        empService.updateEmp(emp);
        return  "redirect:/emp/findAll";

    }


}
