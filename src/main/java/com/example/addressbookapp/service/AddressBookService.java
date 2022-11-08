package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.email.EmailService;
import com.example.addressbookapp.exception.CustomException;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    EmailService emailService;

    public AddressBookData createAddressBooklData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
//        emailService.sendEmail(addressBookDTO.getEmail(), "Address Book Detail SuccessFully", "Hello " + addressBookData.getFirstName() + " " + addressBookData.getLastName() + " your address book record was added successfully");
        return addressBookRepository.save(addressBookData);
    }


    public AddressBookData updateAddresBookData(AddressBookDTO addressBookDTO, int id) {
        if (addressBookRepository.existsById(id)) {
            AddressBookData addressBookData = addressBookRepository.findById(id).get();
            addressBookData.setFirstName(addressBookDTO.getFirstName());
            addressBookData.setLastName(addressBookDTO.getLastName());
            addressBookData.setAddress(addressBookDTO.getAddress());
            addressBookData.setCity(addressBookDTO.getCity());
            addressBookData.setState(addressBookDTO.getState());
            return addressBookRepository.save(addressBookData);
        } else {
            throw new CustomException("Address Book Details Not found! id " + id);
        }
    }

    public String deleteAddressBookData(int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            addressBookRepository.deleteById(id);
            return "Contact with ID: " + id + " is Deleted Successfully!!";
        }else
            throw new CustomException("No contact matches with the given ID");
    }

    public List<AddressBookData> findAllAddressBookData() {
        if (!addressBookRepository.findAll().isEmpty()) {
            return addressBookRepository.findAll();
        } else throw new CustomException("Address Book is Empty!");
    }


    public Optional<AddressBookData> getAddressBookDataId(int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            return addressBookRepository.findById(id);
        } else {
            throw new CustomException("Address is not found! id = " + id + " not found");
        }
    }

    public List<AddressBookData> findByName(String firstName) {
        if(!addressBookRepository.findContactByName(firstName).isEmpty()){
            return addressBookRepository.findContactByName(firstName);
        }else{
            throw new CustomException("No contact with "+ firstName+" found!!!" );
        }
    }

}
