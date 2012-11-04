package net.test.spring3.controller;

import java.util.ArrayList;
import java.util.List;

import net.test.spring3.form.Contact;
import net.test.spring3.form.ContactForm;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class ContactController {
 
	private static List<Contact> contacts = new ArrayList<Contact>();
	 
    static {
        contacts.add(new Contact("Test1", "Test1LN", "test1@email.com", "147-852-965"));
        contacts.add(new Contact("Test2", "Test2LN", "test2@email.com", "147-852-455"));
        contacts.add(new Contact("Test3", "Test3LN", "test3@email.com", "144-852-455"));
        contacts.add(new Contact("Test4", "Test4LN", "test4@email.com", "147-852-411"));
    }
	
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get() {         
        ContactForm contactForm = new ContactForm();
        contactForm.setContacts(contacts);         
        return new ModelAndView("add_contact" , "contactForm", contactForm);
    }
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("contactForm") ContactForm contactForm) {
        //System.out.println(contactForm);
        //System.out.println(contactForm.getContacts());
        List<Contact> contacts = contactForm.getContacts();
         
        if(null != contacts && contacts.size() > 0) {
            ContactController.contacts = contacts;
            for (Contact contact : contacts) {
                System.out.printf("%s \t %s \n", contact.getFirstname(), contact.getLastname());
            }
        }
         
        return new ModelAndView("show_contact", "contactForm", contactForm);
    }
    
	
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
                            Contact contact, BindingResult result) {
         
        System.out.println("First Name:" + contact.getFirstname() +
        					"Last Name:" + contact.getLastname());
         
        return "redirect:contacts.html";
    }
     
    @RequestMapping("/contacts")
    public ModelAndView showContacts() {         
        return new ModelAndView("contact", "command", new Contact());
    }
}