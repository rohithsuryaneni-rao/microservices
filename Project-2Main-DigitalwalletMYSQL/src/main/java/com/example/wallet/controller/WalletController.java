package com.example.wallet.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.wallet.model.UserDetail;
import com.example.wallet.service.WalletService;
@RestController
@RequestMapping("/api")
public class WalletController 
{
	@Autowired 
	private WalletService walletService;
	@PostMapping("/register")
	public UserDetail registerUser(@RequestBody UserDetail user)
	{
		user.getCertificatedetails().forEach(c->c.setUserDetail(user));
		walletService.saveUser(user);
		user.getCertificatedetails().forEach(c->walletService.saveCer(c));
		return walletService.saveUser(user);
	}
    @GetMapping("/usersinfo")
    public List<UserDetail> getAllMembers() 
    {
        return walletService.findAll();
    }
    @GetMapping("/usersinfo/{num}") 
    public ResponseEntity<UserDetail> getMemberById(@PathVariable int num) 
    {
    	UserDetail member = walletService.findById(num);
        return member != null ? ResponseEntity.ok(member) : ResponseEntity.notFound().build();
    }
    @GetMapping("/usersget/{name}")
    public ResponseEntity<List<UserDetail>> getMembersByName(@PathVariable String name) 
    {
        List<UserDetail> members = walletService.findByName(name);
        return members.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(members);
    }
    @PutMapping("/update/{num}")
    public ResponseEntity<UserDetail> updateUser(@PathVariable int num,@RequestBody UserDetail user)
    {
    	UserDetail u=walletService.findById(num);
        if (u==null) 
        {
            return ResponseEntity.notFound().build();
        }
    	u.setName(user.getName());
    	u.setAge(user.getAge());
    	UserDetail us=walletService.saveUser(u);
    	return ResponseEntity.ok(us);
    }
}