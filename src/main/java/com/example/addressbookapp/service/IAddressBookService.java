package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {

    AddressBookData createAddressBooklData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddresBookData(AddressBookDTO addressBookDTO, int id);

    String deleteAddressBookData(int id);

    List<AddressBookData> findAllAddressBookData();

    Optional<AddressBookData> getAddressBookDataId(int id);

    List<AddressBookData> findByName(String firstName);

}
