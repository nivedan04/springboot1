package controller;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
abstract
class EmployeeControllerTest {

    @Autowired
    CompanyRepo cRepo;

    @Test
    public void testcase1(){
        Company c = new Company();
        c.setId(1);
        c.setCompanyBranch("tcs");
        c.setCompanyBranch("banglore");
        cRepo.save(c);
        assertNotNull(cRepo.findById(1).get());
    }

    @Test
    public void testReadAll(){
        List<Company> list = cRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
    @Test
    public void testSingleCompany(){
        Company company = cRepo.findById(1).get();
        assertEquals("banglore",company.getCompanyBranch());

    }


    @Test
    public void testCompanyUpdate(){
        Company c = cRepo.findById(1).get();
        c.setCompanyBranch("hyderbad");
        cRepo.save(c);
        assertNotEquals("banglore",cRepo.findById(1).get().getCompanyBranch());
    }
    @Test
    public void testCompanyDelete(){
        cRepo.deleteById(1);
        assertThat(cRepo.existsById(2)).isFalse();
    }

    @Autowired
    EmployeeRepository eRepo;

    @Test
    public void testCreate2() {
        Employee e = new Employee();
        e.setEmpid(1);
        e.setEmpdept("digital");
        e.setEmplocation("banglore");
        eRepo.save(e);
        assertNotNull(eRepo.findById(1).get());

    }

    @Test
    public void testReadAll2(){
        List<Employee> list = eRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void testSingleEmployee(){
        Employee employee = eRepo.findById(1).get();
        assertEquals("banglore",employee.getEmplocation());

    }

    @Test
    public void testemployeDelete(){
        eRepo.deleteById(1);
        assertThat(eRepo.existsById(2)).isFalse();
    }

    @Test
    public void testemployeUpdate(){
        Employee e = eRepo.findById(1).get();
        e.getEmpdept("digital");
        eRepo.save(e);
        assertNotEquals("",eRepo.findById(1).get().getEmpdept());
    }
}