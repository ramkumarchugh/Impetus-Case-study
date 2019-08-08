package com.insurance.app.test;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.insurance.app.dao.InsuranceDao;
import com.insurance.app.model.Role;
import com.insurance.app.model.User;
import com.insurance.app.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;
    
    @MockBean
    private InsuranceDao insuranceDao;
    
    private List<User> list = new ArrayList<>();
    
    private Optional<User> u ;
    Role role = new Role(1,"admin");
    
    User user = new User(1,"Divyansh","divyansh@gmail.com","12345","Indore","MP"," asdgha",new Date(0),"3698521470",role);

    String email="divyansh@gmail.com";
    int roleId=1;
    int userId=2;

    @Test
    public void testGetUsers() {
        list.add(user);
        when(insuranceDao.findAll()).thenReturn(list);
        assertEquals(list,userService.getUsers());  
    }
    
    @Test
    public void testGetUserByEmail() {
        
        list.add(user);
        when(insuranceDao.findByEmail(email)).thenReturn(user);
        assertEquals(user,userService.getUserByEmail(email));
    }
    
    @Test
    public void testAddNewUser() {
        list.add(user);
        when(insuranceDao.save(user)).thenReturn(user);
        assertEquals(user,userService.addNewUser(user));
    
    }
    
    
    @Test
    public void testUpdateUser() {
        list.add(user);
        when(insuranceDao.save(user)).thenReturn(user);
        assertEquals(user,userService.updateUser(user)); 
         
    }
    
    @Test
    public void testGetUserByRoleId() {
        list.add(user);
        when(insuranceDao.findByRole(roleId)).thenReturn(list);
        assertEquals(list,userService.getUserByRoleId(roleId));
        
        
    }
    
//   @Test
//   public void testDeleteUserById() {
//       list.add(user);
//       when(insuranceDao.deleteById(userId)).thenReturn(list);
//       assertEquals(list,userService.deleteUserById(userId));   
//   }
   
   
}
