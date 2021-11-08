package com.prepavenger.controller;

import java.util.List;




import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepavenger.Repository.ArrayRepo;
import com.prepavenger.Repository.DpRepo;
import com.prepavenger.Repository.GraphRepo;
import com.prepavenger.Repository.GreedyRepo;
import com.prepavenger.Repository.StackQRepo;
import com.prepavenger.Repository.StringRepo;
import com.prepavenger.Repository.UserRepository;
import com.prepavenger.emailService.EmailService;
import com.prepavenger.entities.ArrayClass;
import com.prepavenger.entities.DpClass;
import com.prepavenger.entities.GraphClass;
import com.prepavenger.entities.GreedyClass;
import com.prepavenger.entities.Output;
import com.prepavenger.entities.StackQueClass;
import com.prepavenger.entities.StringClass;
import com.prepavenger.entities.User;


@RestController
@CrossOrigin
public class PrepAvengerController {
		
		@Autowired
		private UserRepository userRepository;
		@Autowired
		private ArrayRepo arrayrepo; 
		
		@Autowired
		private StringRepo stringrepo;
		
		@Autowired
		private GraphRepo graphrepo;
		
		@Autowired
		private StackQRepo stackqrepo;
		@Autowired
		private DpRepo dprepo;
		
		@Autowired
		private GreedyRepo greedyrepo;
		
		@Autowired
		private EmailService emailservice;

		
		@GetMapping("/welcome")
		public String Test() {
			return "Hello";
		}
		
		@GetMapping("/home")
		public User Testing() {
			Optional<User> optional=userRepository.findById(1);
			return optional.get();
		}
		
		@PostMapping("/verifyuser")
		public ResponseEntity<String> verifyuser(@RequestBody User user) {
			String emailString=user.getUserEmail();
			Random random=new Random();
			
			String number=String.format("%06d",random.nextInt(1000000));
			String otpString=number;
			number="Hello User!!! <br> Your otp for singup  is <strong>"+number+"</strong> <br><br>Happy Hacking <br> <strong>PrepAvenger!</strong>";
			boolean send=emailservice.sendEmail("Otp Verification || PrepAvenger", number, emailString);
//			userRepository.save(user);
//			System.out.println(user);
			if(send) {
				return ResponseEntity.of(Optional.of(otpString));
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		@PostMapping("/sendotp")
		
		public ResponseEntity<String> sendotp(@RequestBody User user) {
			User user1=userRepository.findByUserName(user.getUserEmail());
			System.out.print(user.getUserEmail());
//			System.out.print(emailString);
			
			if(user1!=null) {
				
				Random random=new Random();
				
				String number=String.format("%06d",random.nextInt(1000000));
				String otpString=number;
				number="Hello User!!! <br> Your otp for Password reset is <strong>"+number+"</strong> <br><br>Happy Hacking <br> <strong>PrepAvenger!</strong>";
				boolean send=emailservice.sendEmail("Password Reset || PrepAvenger", number, user.getUserEmail());
//				System.out.pro
				if(send) {
					return ResponseEntity.of(Optional.of(otpString));
				}
			}
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			
			
		}
		
		@PostMapping("/resetpass")
		public ResponseEntity<User> resetPassword(@RequestBody User user) {
			try {
				
			 
			User user2=userRepository.findByUserName(user.getUserEmail());
			
			System.out.println(user.getUserEmail());
			user2.setUserPassword(user.getUserPassword());
			
			User userOptional=userRepository.save(user2);
			return ResponseEntity.of(Optional.of(userOptional));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		
		
		@PostMapping("/adduser")
		public ResponseEntity<User> addUser(@RequestBody User user) {
			try {
			User userOptional=userRepository.save(user);
			return ResponseEntity.of(Optional.of(userOptional));

			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		@GetMapping("/getarrayproblems")
		public ResponseEntity<List<ArrayClass>> getArrayProblem() {
			try {
			List<ArrayClass> list=arrayrepo.findAll();
				return ResponseEntity.of(Optional.of(list));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		@GetMapping("/getstringproblems")
		public ResponseEntity<List<StringClass>> getStringProblem() {
			try {
			List<StringClass> list=stringrepo.findAll();
			return ResponseEntity.of(Optional.of(list));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		@GetMapping("/getstackqueueproblems")
		public ResponseEntity<List<StackQueClass>> getStackQProblem() {
			try {
			List<StackQueClass> list=stackqrepo.findAll();
			return ResponseEntity.of(Optional.of(list));
		
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		@GetMapping("/getgreedyproblems")
		public ResponseEntity<List<GreedyClass>> getGreedyProblem() {
			try {
			List<GreedyClass> list=greedyrepo.findAll();
			return ResponseEntity.of(Optional.of(list));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			} 
		}
		
		@GetMapping("/getgraphproblems")
		public ResponseEntity<List<GraphClass>> getGraphProblem() {
			try {
			List<GraphClass> list=graphrepo.findAll();
			return ResponseEntity.of(Optional.of(list));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				
			}
			
		}
		
		@GetMapping("/getdpproblems")
		public ResponseEntity<List<DpClass>> getDpProblem() {
			try {
			List<DpClass> list=dprepo.findAll();
			return ResponseEntity.of(Optional.of(list));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		@GetMapping("/getarrayproblems/{problemid}")
		public ResponseEntity<ArrayClass> getArrayproblemById(@PathVariable int problemid) {
			
			try {
			Optional<ArrayClass> optional=arrayrepo.findById(problemid);
			
			return ResponseEntity.of(Optional.of(optional.get()));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		@GetMapping("/getstringproblems/{problemid}")
		public ResponseEntity<StringClass> getStringproblemById(@PathVariable int problemid) {
			
			try {
			Optional<StringClass> optional=stringrepo.findById(problemid);
			
			return ResponseEntity.of(Optional.of(optional.get()));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		@GetMapping("/getgreedyproblems/{problemid}")
		public ResponseEntity<GreedyClass> getGdeeryproblemById(@PathVariable int problemid) {
			
			try {
			Optional<GreedyClass> optional=greedyrepo.findById(problemid);
			
			return ResponseEntity.of(Optional.of(optional.get()));
			}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		@GetMapping("/getgraphproblems/{problemid}")
		public ResponseEntity<GraphClass> getGraphproblemById(@PathVariable int problemid) {
			
			try {
			Optional<GraphClass> optional=graphrepo.findById(problemid);
			
			return ResponseEntity.of(Optional.of(optional.get()));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		@GetMapping("/getdpproblems/{problemid}")
		public ResponseEntity<DpClass> getDpproblemById(@PathVariable int problemid) {
			
			try {
			Optional<DpClass> optional=dprepo.findById(problemid);
			
			return ResponseEntity.of(Optional.of(optional.get()));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		@GetMapping("/getstackqueueproblems/{problemid}")
		public ResponseEntity<StackQueClass> getStackQueneproblemById(@PathVariable int problemid) {
			
			try {
			
			Optional<StackQueClass> optional=stackqrepo.findById(problemid);
			
			return ResponseEntity.of(Optional.of(optional.get()));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		@PostMapping("/loginuser")
		public ResponseEntity<User> loginUser(@RequestBody User user) {
			
			try {
			User user1=userRepository.findByUserName(user.getUserEmail());
			
			if(user.getUserPassword().equals(user1.getUserPassword())) {
				return ResponseEntity.of(Optional.of(user1));
			}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		@PostMapping("/addarrayproblems")
		public ResponseEntity<ArrayClass> addArrayprob(@RequestBody ArrayClass arrayClass) {
			
//			System.out.print(arrayClass.toString());
			try {
			ArrayClass obj=arrayrepo.save(arrayClass);
			return ResponseEntity.of(Optional.of(obj));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			
		}
		@PostMapping("/addstringproblems")
		public ResponseEntity<StringClass> addStringprob(@RequestBody StringClass stringClass) {
			try {
			StringClass obj=stringrepo.save(stringClass);
			return ResponseEntity.of(Optional.of(obj));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			
		}
		@PostMapping("/addstackqueueproblems")
		public ResponseEntity<StackQueClass> addStackQprob(@RequestBody StackQueClass stackQueClass) {
			try {
			StackQueClass obj=stackqrepo.save(stackQueClass);
			return ResponseEntity.of(Optional.of(obj));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			
		}
		@PostMapping("/addgreedyproblems")
		public ResponseEntity<GreedyClass> addGreedyprob(@RequestBody GreedyClass greedyClass) {
			try {
			GreedyClass obj=greedyrepo.save(greedyClass);
			return ResponseEntity.of(Optional.of(obj));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		@PostMapping("/addgraphproblems")
		public ResponseEntity<GraphClass> addGraphprob(@RequestBody GraphClass graphClass) {
			try {
			GraphClass obj=graphrepo.save(graphClass);
			return ResponseEntity.of(Optional.of(obj));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		@PostMapping("/adddpproblems")
		public ResponseEntity<DpClass> addDpprob(@RequestBody DpClass dpClass) {
			try {
			 DpClass obj=dprepo.save(dpClass);
			 return ResponseEntity.of(Optional.of(obj));
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		@PostMapping("/testcasecheck")
		public int test(@RequestBody Output output) {
			System.out.println(output.getOutputString());
			System.out.println(output.getActualoutputString());
			return output.comapre(output);
		}
}