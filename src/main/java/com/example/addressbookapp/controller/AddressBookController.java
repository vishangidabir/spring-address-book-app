package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResposeDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService;
    /**
     * Create and add address book details to database
     * this is POST call
     * http://localhost:8080/addressbookservice/createAddressBook
     */
    @PostMapping("/createAddressBook")
    public AddressBookData createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
//        ResposeDTO responseDTO = new ResposeDTO("Added Successfully", addressBookService.createAddressBooklData(addressBookDTO));
        return addressBookService.createAddressBooklData(addressBookDTO);
    }

    /**
     * Update address book in database by Id
     * this is PUT call
     * http://localhost:8080/addressbookservice/updateAddressBook/1
     */

    @PutMapping("/updateAddressBook/{id}")
    public ResponseEntity<ResposeDTO> updateAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO, @PathVariable int id) {
        ResposeDTO responseDTO = new ResposeDTO("Updated Address Book data Successfully", addressBookService.updateAddresBookData(addressBookDTO, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Delete address book from database by Id
     * this is DELETE call
     * http://localhost:8080/addressbookservice/deleteAddressBook/1
     */
    @DeleteMapping("/deleteAddressBook/{id}")
    public ResponseEntity<ResposeDTO> deleteAddressBook(@PathVariable int id) {
        ResposeDTO responseDTO = new ResposeDTO("Successfully deleted", addressBookService.deleteAddressBookData(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    /**
     * gets all employees from database
     * this is GET call
     * http://localhost:8080/addressbookservice/getAllAddressBook
     */
    @GetMapping("/getAllAddressBook")
    public ResponseEntity<ResposeDTO> getAllAddressBook() {
        ResposeDTO responseDTO = new ResposeDTO("Succeeded", addressBookService.findAllAddressBookData());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * gets employee from database by ID
     * this is GET call
     * http://localhost:8080/addressbookservice/getAddressBook/1
     */
    @GetMapping("/findAddressBook/{id}")
    public ResponseEntity<ResposeDTO> getAddressBook(@PathVariable int id) {
        ResposeDTO responseDTO = new ResposeDTO("Succeeded", addressBookService.getAddressBookDataId(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getContactByName")
    public ResponseEntity<ResposeDTO> findContactByName(@RequestParam String firstName){
        ResposeDTO responseDTO = new ResposeDTO("Retrieved",addressBookService.findByName(firstName));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}





